package kep.workshop

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
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

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.baseRoute() {
    routing {
        get {
            call.respondText("Hello Kotlin/Everywhere Paris 2019!", ContentType.Text.Plain)
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

                get("/list") {
                    val currentUser = call.principal<UserIdPrincipal>()

                    if (currentUser != null) {
                        val session: UserSession = call.sessions.get<UserSession>() ?: UserSession(currentUser.name, 1)
                        call.sessions.set(UserSession(currentUser.name, session.counter + 1))

                        call.respond(HttpStatusCode.OK, session to repository.findAll())
                    } else                    call.respond(HttpStatusCode.OK, repository.findAll())
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