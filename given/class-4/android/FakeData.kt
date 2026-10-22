package rs.pmf.parkmini.data

import com.v1.parkmini.shared.ParkingSpot
import com.v1.parkmini.shared.SpotStatus
import com.v1.parkmini.shared.Zone
import kotlin.random.Random

// Lažni podaci dok aplikacija još nije povezana sa serverom. Ista ideja kao sampleSpots() na serveru.
fun fakeSpots(): List<ParkingSpot> {
    val spots = mutableListOf<ParkingSpot>()
    var id = 1
    for (zone in Zone.entries) {
        for (num in 1..6) {
            val status = when {
                zone == Zone.C && num == 6 -> SpotStatus.Unavailable
                Random.nextDouble() < 0.4 -> SpotStatus.Occupied("KG-123-AB")
                else -> SpotStatus.Free
            }
            spots.add(ParkingSpot(id, "$zone$num", zone, status))
            id++
        }
    }
    return spots
}
