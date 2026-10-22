package com.v1.playground

import com.v1.parkmini.sampleSpots
import com.v1.parkmini.shared.ParkingSpot
import com.v1.parkmini.shared.SpotStatus
import com.v1.parkmini.shared.Zone

fun main() {
    val spot = ParkingSpot(1, "A1", Zone.A)
    println(spot)

    val spot2 = spot.copy(zone = Zone.B)
    println(spot)
    println(spot2)

    val zauzeto = ParkingSpot(
        2, "A2", Zone.A,
        SpotStatus.Occupied("KG-123-KG")
    )

    val spots = sampleSpots(0.4)
    println(spots.size)
    println(spots)
    println(spots.count { it.status is SpotStatus.Occupied })

}