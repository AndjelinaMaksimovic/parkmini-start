package com.v1.parkmini

import com.v1.parkmini.shared.ParkingSpot
import com.v1.parkmini.shared.SpotStatus
import com.v1.parkmini.shared.Zone
import kotlin.random.Random

fun sampleSpots(occupiedShare: Double): List<ParkingSpot> {
    val spots = mutableListOf<ParkingSpot>()
    var id = 1

    for (zone in Zone.values()) {
        for (num in 1..6) {
            val status = when {
                zone == Zone.C && num == 6 -> SpotStatus.Unavailable
                Random.nextDouble() < occupiedShare
                    -> SpotStatus.Occupied(randomSimulatedPlate())

                else -> SpotStatus.Free
            }
            spots.add(ParkingSpot(id, "$zone$num", zone, status))
            id++
        }
    }

    return spots
}

const val SIMULATED_PREFIX = "SIM-"

fun randomSimulatedPlate(): String = "$SIMULATED_PREFIX${Random.nextInt(100, 1000)}"
