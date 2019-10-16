package kep.workshop

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
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
        route("/speaker") {
            get("/list") {
                call.respond(HttpStatusCode.OK, speakers.values)
            }
            get("/{id}") {
                val speaker =
                    try {
                        speakers[call.parameters["id"]]
                    } catch (e: NoSuchElementException) {
                        null
                    }

                if (speaker == null) call.respond(HttpStatusCode.NotFound)
                else
                    call.respond(HttpStatusCode.OK, speaker)
            }
        }

        route("/talk") {
            get("/list") {
                val type = call.request.queryParameters["type"]

                val talkList =
                    if (type == null) talks.values
                    else talks.values.filter { it.type.equals(type, ignoreCase = true) }

                if (talkList.isEmpty()) call.respond(HttpStatusCode.NotFound)
                else call.respond(HttpStatusCode.OK, talkList)
            }

            get("/{id}") {
                val talk =
                    try {
                        talks[call.parameters["id"]]
                    } catch (e: NoSuchElementException) {
                        null
                    }

                if (talk == null) call.respond(HttpStatusCode.NotFound)
                else call.respond(HttpStatusCode.OK, talk)
            }
        }
    }
}