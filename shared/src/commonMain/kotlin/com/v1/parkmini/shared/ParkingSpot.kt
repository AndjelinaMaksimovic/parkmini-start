package com.v1.parkmini.shared

import kotlinx.serialization.Serializable

@Serializable
data class ParkingSpot(
    val id: Int,
    val label: String,
    val zone: Zone,
    val status: SpotStatus = SpotStatus.Free,
)