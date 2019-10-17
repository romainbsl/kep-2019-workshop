package kep.workshop

import com.fasterxml.jackson.databind.SerializationFeature
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.*
import io.ktor.features.ContentNegotiation
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.html.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.sessions.*
import kotlinx.html.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.baseRoute() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        get {
            call.respondHtml {
                head {
                    title { +"Ktor Workshop" }
                }
                body {
                    h1 { +"Hello, Kotlin/Everywhere Paris 2019" }
                    ul {
                        li { a {
                            href = "/talk"
                            +"List des talks"
                        } }
                        li {
                            a {
                                href = "/speaker"
                                +"Liste des speakers"
                            }
                        }
                    }
                }
            }
        }
    }
}

fun Application.endpoints() {
    routing {
        route("/endpoints") {
            get {
                call.respondText("BONJOUR")
            }
            post {
                val body = call.receive<String>()
                call.respondText("""
                _____________________                              _____________________
                                                 $body
                _____________________                              _____________________
                `-._:  .:'   `:::  .:\           |\__/|           /::  .:'   `:::  .:.-'
                    \      :          \          |:   |          /         :       /    
                     \     ::    .     `-_______/ ::   \_______-'   .      ::   . /      
                      |  :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: :|       
                      |     ;::         ;::         ;::         ;::         ;::  |       
                      |  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:|       
                      /     :           :           :           :           :    \       
                     /______::_____     ::    .     ::    .     ::   _____._::____\      
                                   `----._:: ::'  :   :: ::'  _.----'                    
                                          `--.       ;::  .--'                           
                                              `-. .:'  .-'                               
                                                 \    /                             
                                                  \  /                                   
                                                   \/ 
                """.trimIndent())
            }
        }
    }
}

fun Application.contentNegotiation() {
    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }

    routing {
        authenticate("basicAuth") {
            route("/speaker") {
                val repository = SpeakerRepository()

                get {
                    val speakerList = repository.findAll()
                    val currentUser = call.principal<UserIdPrincipal>()

                    val count = if (currentUser != null) {
                        val session: UserSession = call.sessions.get<UserSession>() ?: UserSession(currentUser.name, 1)
                        call.sessions.set(UserSession(currentUser.name, session.counter + 1))
                        session.counter
                    } else 0

                    call.respondHtml {
                        body {
                            a{
                                href = "/"
                                +"Page d'accueil"
                            }
                            p {
                                if (currentUser != null) +"Hello ${currentUser.name}, vous êtes venus ${count} fois sur cette page!"
                            }
                            table {
                                tr {
                                    th { text("Nom") }
                                    th { text("Website") }
                                    th { text("Twitter") }
                                }
                                speakerList.forEach { speaker ->
                                    tr {
                                        td { text(speaker.name) }
                                        td { text(speaker.webSite ?: "") }
                                        td { text(speaker.twitter ?: "") }
                                    }
                                }
                            }
                        }
                    }
                }

                get("/list") {
                    val currentUser = call.principal<UserIdPrincipal>()

                    if (currentUser != null) {
                        val session: UserSession = call.sessions.get<UserSession>() ?: UserSession(currentUser.name, 1)
                        call.sessions.set(UserSession(currentUser.name, session.counter + 1))

                        call.respond(HttpStatusCode.OK, session to repository.findAll())
                    } else call.respond(HttpStatusCode.OK, repository.findAll())
                }
                get("/{id}") {
                    val speaker = repository.findById(call.parameters["id"] ?: "")

                    if (speaker == null) call.respond(HttpStatusCode.NotFound)
                    else call.respond(HttpStatusCode.OK, speaker)
                }
            }
        }

        route("/talk") {
            val repository = TalkRepository()

            get {
                val session: UserSession? = call.sessions.get<UserSession>()
                call.respond(FreeMarkerContent("talks.ftl", mapOf("username" to session?.username, "talkList" to repository.findAll()), "e"))
            }

            get("/list") {
                val type = call.request.queryParameters["type"]

                val talkList = repository.findByType(type)

                if (talkList.isEmpty()) call.respond(HttpStatusCode.NotFound)
                else call.respond(HttpStatusCode.OK, talkList)
            }

            get("/{id}") {
                val talk =
                    try {
                        repository.findById(call.parameters["id"] ?: "")
                    } catch (e: NoSuchElementException) {
                        null
                    }

                if (talk == null) call.respond(HttpStatusCode.NotFound)
                else call.respond(HttpStatusCode.OK, talk)
            }
        }
    }
}

fun Application.auth() {
    install(Authentication) {
        basic("basicAuth") {
            realm = "Ktor Server"
            validate {
                val repository = UserRepository()
                if (repository.check(it.name, it.password)) UserIdPrincipal(it.name) else null
            }
        }
    }
}

data class UserSession(val username: String, val counter: Int = 0)

fun Application.session() {
    install(Sessions) {
        cookie<UserSession>("SESSION_FEATURE_SESSION_ID", SessionStorageMemory()) {
            cookie.path = "/" // Specify cookie's path '/' so it can be used in the whole site
        }
    }
}