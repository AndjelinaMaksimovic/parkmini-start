package com.v1.parkmini

import com.v1.parkmini.shared.ActionResult
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import com.v1.parkmini.shared.LicensePlateRequest
import com.v1.parkmini.shared.isValidLicensePlate
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
import kotlinx.coroutines.launch

fun main() {
    val repository: ParkingRepository = ParkingRepository(sampleSpots(0.4))

    embeddedServer(Netty, port = 8080, host = "localhost") {
        install(ContentNegotiation) { json() }

        launch { sensorSimulator(repository) }

        routing {
            get("/") { call.respondText("ParkMini works!") }
            get("/api/spots") { call.respond(repository.spots.value) }

            post("/api/spots/{id}/occupy") {
                call.handleAction { id, licensePlate -> repository.occupy(id, licensePlate) }
            }

            post("/api/spots/{id}/release") {
                call.handleAction { id, licensePlate -> repository.release(id, licensePlate) }
            }
        }


    }.start(wait = true)
}

private suspend fun ApplicationCall.handleAction(action: (id: Int, licensePlate: String) -> ActionResult) {
    val id = parameters["id"]?.toIntOrNull()
        ?: return respondText("Invalid id", status = HttpStatusCode.BadRequest)
    val request = receive<LicensePlateRequest>()
    if (!request.licensePlate.isValidLicensePlate()) {
        return respondText("Invalid license plate: ${request.licensePlate}", status = HttpStatusCode.BadRequest)
    }
    respondResult(action(id, request.licensePlate))
}

private suspend fun ApplicationCall.respondResult(result: ActionResult) = when (result) {
    is ActionResult.Success -> respond(result.spot)
    is ActionResult.NotFound -> respondText("Spot ${result.id} does not exist", status = HttpStatusCode.NotFound)
    is ActionResult.Conflict -> respondText(result.message, status = HttpStatusCode.Conflict)
}
