package com.v1.parkmini.shared

sealed interface ActionResult {
    data class Success(val spot: ParkingSpot) : ActionResult
    data class Conflict(val message: String) : ActionResult
    data class NotFound(val id: Int) : ActionResult
}