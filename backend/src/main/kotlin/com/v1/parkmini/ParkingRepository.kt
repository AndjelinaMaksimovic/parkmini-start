package com.v1.parkmini

import com.v1.parkmini.shared.ActionResult
import com.v1.parkmini.shared.ParkingSpot
import com.v1.parkmini.shared.SpotStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ParkingRepository(
    initial: List<ParkingSpot>
) {
    private val _spots = MutableStateFlow(initial)
    val spots: StateFlow<List<ParkingSpot>> = _spots.asStateFlow()

    private fun find(id: Int): ParkingSpot? = _spots.value.find { it.id == id }

    @Synchronized
    fun occupy(id: Int, licensePlate: String): ActionResult {
        val spot = find(id) ?: return ActionResult.NotFound(id)
        if (spot.status !is SpotStatus.Free) return ActionResult.Conflict("This spot is not free.")

        val occupied = spot.copy(status = SpotStatus.Occupied(licensePlate))
        replace(occupied)
        return ActionResult.Success(occupied)
    }

    private fun replace(updated: ParkingSpot) {
        _spots.value = _spots.value.map {
            if (it.id == updated.id) updated else it
        }
    }

    @Synchronized
    fun release(id: Int, licensePlate: String): ActionResult {
        val spot = find(id) ?: return ActionResult.NotFound(id)
        val status = spot.status
        if (status !is SpotStatus.Occupied ||
            status.licensePlate != licensePlate
        )
            return ActionResult.Conflict("This spot is not free.")
        val free = spot.copy(status = SpotStatus.Free)
        replace(free)
        return ActionResult.Success(free)
    }


}