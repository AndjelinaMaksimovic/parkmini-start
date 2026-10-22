package com.v1.parkmini

import com.v1.parkmini.shared.ActionResult
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun main() {
    val repository: ParkingRepository = ParkingRepository(sampleSpots(0.4))

    embeddedServer(Netty, port = 8080, host = "localhost") {
        install(ContentNegotiation) { json() }

        routing {
            get("/") { call.respondText("ParkMini works!") }
            get("/api/spots") { call.respond(repository.spots.value) }

            post("/api/spots/{id}/occupy") {
                call.handleMyAction { }
            }
        }


    }.start(wait = true)
}

