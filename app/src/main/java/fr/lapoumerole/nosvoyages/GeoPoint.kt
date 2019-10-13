package fr.lapoumerole.nosvoyages

import com.google.android.gms.maps.model.LatLng

data class GeoPoint(

        var latlon: LatLng = LatLng(45.960131,2.681821),
        var typMark: Int = 0,
        var name: String = "",
        var snippet: String = ""
) {

}