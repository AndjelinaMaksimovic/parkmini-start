package com.v1.parkmini

import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

suspend fun sensorSimulator(repository: ParkingRepository): Nothing {
    while (true) {
        delay(Random.nextDouble(2.0, 6.0).seconds)
        repository.simulateSensor()
    }
}
