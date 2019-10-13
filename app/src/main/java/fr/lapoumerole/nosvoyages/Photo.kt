package fr.lapoumerole.nosvoyages

import java.time.LocalDate

data class Photo(
        var uri: String = "",
        var date: LocalDate = LocalDate.now(),
        var lieu: GeoPoint = GeoPoint(),
        var legend: String = ""
)
{
}