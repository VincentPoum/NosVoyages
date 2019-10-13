package fr.lapoumerole.nosvoyages

import java.time.LocalDate

class Etape(
        var name :	String = "",
        var trajet: MutableList<GeoPoint> = mutableListOf<GeoPoint>(),
        var photos: MutableList<Photo> = mutableListOf<Photo>(),
        var debut: LocalDate = LocalDate.now(),
        var fin: LocalDate = LocalDate.now()
) {
}