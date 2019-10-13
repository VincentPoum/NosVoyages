package fr.lapoumerole.nosvoyages

import com.google.android.gms.maps.model.LatLng
import java.time.LocalDate

class Voyage(
        var id: Int = 0,
        var nom: String = "",
        var debut: LocalDate = LocalDate.now(),
        var fin: LocalDate = LocalDate.now(),
        var participants: MutableList<Personne> = mutableListOf<Personne>(),
        var barycentre: GeoPoint = GeoPoint(),
        var etapes: MutableList<Etape> = mutableListOf<Etape>()
)




val nosVoyages = setOf(
Voyage(1,"Nord-Ouest argentin", barycentre = GeoPoint(LatLng( -26.9119149,-65.0976044)),
        debut = LocalDate.of(2012,2,24), fin = LocalDate.of(2012,3,9)),
Voyage(2,"Nouvelle Calédonie", barycentre = GeoPoint(LatLng(-21.1998083,164.7201475)),
debut = LocalDate.of(2012,10,16), fin = LocalDate.of(2012,11,9)),
Voyage(3,"Afrique du Sud - Parcs", barycentre = GeoPoint(LatLng(-25.360857, 31.260480)),
debut = LocalDate.of(2013,2,14), fin = LocalDate.of(2013,3,6)),
Voyage(4,"Andalousie", barycentre = GeoPoint(LatLng(37.2765948,-5.1776781)),
debut = LocalDate.of(2013,5,16), fin = LocalDate.of(2013,5,21)),
Voyage(5,"Allemagne - Nord et Berlin", barycentre = GeoPoint(LatLng(52.700427, 12.055471)),
debut = LocalDate.of(2013,7,22), fin = LocalDate.of(20134,8,15)),
Voyage(6,"Australie", barycentre = GeoPoint(LatLng(-29.864086, 152.224269)),
debut = LocalDate.of(2013,11,7), fin = LocalDate.of(2013,12,10)),
Voyage(7,"Inde du Sud", barycentre = GeoPoint(LatLng(11.158213, 78.184748)),
debut = LocalDate.of(2014,1,31), fin = LocalDate.of(2014,2,26)),
Voyage(8,"Allemagne - Echange Bruchsal", barycentre = GeoPoint(LatLng(49.10694,8.3450175)),
debut = LocalDate.of(2014,9,5), fin = LocalDate.of(2014,9,23)),
Voyage(9,"New York - Los Angeles", barycentre = GeoPoint(LatLng(38.769847, -97.355928)),
debut = LocalDate.of(2015,1,25), fin = LocalDate.of(2015,2,22)),
Voyage(10,"Pavie - Milan", barycentre = GeoPoint(LatLng(45.323499, 9.154027)),
debut = LocalDate.of(2015,3,30), fin = LocalDate.of(2015,4,1)),
Voyage(11,"Corse - Calenzana", barycentre = GeoPoint(LatLng(42.609200, 9.041363)),
debut = LocalDate.of(2015,9,3), fin = LocalDate.of(2015,9,19)),
Voyage(12,"Yorkshire", barycentre = GeoPoint(LatLng(54.335586, -1.645997)),
debut = LocalDate.of(2015,7,2), fin = LocalDate.of(2015,7,23)),
Voyage(13,"Côtes d'Armor", barycentre = GeoPoint(LatLng(48.678191, -2.825874)),
debut = LocalDate.of(2015,9,3), fin = LocalDate.of(2015,9,19)),
Voyage(14,"Rome", barycentre = GeoPoint(LatLng(41.9102411,12.395571)),
debut = LocalDate.of(2015,9,3), fin = LocalDate.of(2015,9,19)),
Voyage(15,"Grèce", barycentre = GeoPoint(LatLng(37.983471, 23.805746)),
debut = LocalDate.of(2016,4,14), fin = LocalDate.of(2016,4,28)),
Voyage(16,"Afrique du Sud - Le Cap", barycentre = GeoPoint(LatLng(-34.014616, 20.656083)),
debut = LocalDate.of(2016,11,9), fin = LocalDate.of(2016,12,1)),
Voyage(17,"Yunnan", barycentre = GeoPoint(LatLng(25.170523,99.6134878)),
debut = LocalDate.of(2017,2,15), fin = LocalDate.of(2017,3,16)),
Voyage(18,"Québec", barycentre = GeoPoint(LatLng(46.840430, -71.548280)),
debut = LocalDate.of(2017,9,18), fin = LocalDate.of(2017,10,12)),
Voyage(19,"Laos - Angkor", barycentre = GeoPoint(LatLng(16.463517, 103.324677)),
debut = LocalDate.of(2018,1,17), fin = LocalDate.of(2018,2,14)),
Voyage(20,"Prague - Vienne", barycentre = GeoPoint(LatLng(49.140811, 15.340623)),
debut = LocalDate.of(2018,5,9), fin = LocalDate.of(2018,6,2)),
Voyage(21,"Sicile Ouest", barycentre = GeoPoint(LatLng(37.876602, 12.870632)),
debut = LocalDate.of(2018,11,23), fin = LocalDate.of(2018,11,30)),
Voyage(22,"Chili - Chiloe", barycentre = GeoPoint(LatLng(-42.6555014,-80.4339578)),
debut = LocalDate.of(2019,1,30), fin = LocalDate.of(2019,2,27)),
Voyage(23,"Géorgie", barycentre = GeoPoint(LatLng(41.824653, 44.003699)),
debut = LocalDate.of(2019,5,27), fin = LocalDate.of(2019,6,7)),
Voyage(24,"Pologne Sud - Budapest", barycentre = GeoPoint(LatLng(48.777939, 19.539686)),
debut = LocalDate.of(2019,9,13), fin = LocalDate.of(2019,10,2))
)
