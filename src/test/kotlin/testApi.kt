package kep.workshop

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun getHelloWorld() {
        withTestApplication({
            baseRoute()
        }) {
            with(handleRequest(HttpMethod.Get, "/")) {
                assertEquals(io.ktor.http.HttpStatusCode.OK, response.status())
                assertEquals("Hello Kotlin/Everywhere Paris 2019!", response.content)
            }
        }
    }
    @Test
    fun get() {
        withTestApplication({
            endpoints()
        }) {
            with(handleRequest(HttpMethod.Get, "/endpoints")) {
                assertEquals(io.ktor.http.HttpStatusCode.OK, response.status())
                assertEquals("BONJOUR", response.content)
            }
        }
    }
    @Test
    fun post() {
        withTestApplication({
            endpoints()
        }) {
            with(handleRequest(HttpMethod.Post, "/endpoints") {
                setBody("BONJOUR")
            }) {
                assertEquals(io.ktor.http.HttpStatusCode.OK, response.status())
                assertEquals("""
                |_____________________                              _____________________
                |`-._:  .:'   `:::  .:\           |\__/|           /::  .:'   `:::  .:.-'
                |    \      :          \          |:   |          /         :       /    
                |     \     ::    .     `-_______/ ::   \_______-'   .      ::   . /      
                |      |  :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: :|       
                |      |     ;::         ;::         ;::         ;::         ;::  |       
                |      |  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:|       
                |      /     :           :           :           :           :    \       
                |     /______::_____     ::    .     ::    .     ::   _____._::____\      
                |                   `----._:: ::'  :   :: ::'  _.----'                    
                |                          `--.       ;::  .--'                           
                |                              `-. .:'  .-'                               
                |                                 \    /                             
                |                                  \  /                                   
                |                                   \/ 
                """.trimMargin(), response.content)
            }
        }
    }
}