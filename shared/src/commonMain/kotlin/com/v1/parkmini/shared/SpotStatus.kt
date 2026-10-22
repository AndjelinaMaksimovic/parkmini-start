package com.v1.parkmini.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface SpotStatus {

    @Serializable
    @SerialName("free")
    data object Free : SpotStatus

    @Serializable
    @SerialName("occupied")
    data class Occupied(val licensePlate: String) : SpotStatus

    @Serializable
    @SerialName("unavailable")
    data object Unavailable : SpotStatus
}