package fr.lapoumerole.nosvoyages

import com.google.android.gms.maps.model.LatLng
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ChargeurVoyage {
    private val lesVoyages = ArrayList<Voyage>()
    private var leVoyage = Voyage()
    private var lItem: String = ""

    fun parse(inputStream: InputStream): MutableList<Voyage>{
        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream,null)
            parser.next()
            var evtType = parser.eventType
            while (evtType != XmlPullParser.END_DOCUMENT){
                val tagname = parser.name

                when (evtType){
                    XmlPullParser.START_TAG -> if (tagname.equals("voyage",ignoreCase = true)){
                        leVoyage = Voyage()
                    }
                    XmlPullParser.TEXT -> lItem = parser.text
                    XmlPullParser.END_TAG -> if (tagname.equals("voyage",ignoreCase = true)){
                        leVoyage.let { lesVoyages.add(it) }
                    } else if (tagname.equals("id", ignoreCase = true)){
                        leVoyage.id = Integer.parseInt(lItem)
                    } else if (tagname.equals("nom", ignoreCase = true)){
                        leVoyage.nom = lItem
                    } else if (tagname.equals("barycentre", ignoreCase = true)){
                        leVoyage.barycentre = GeoPoint(LatLng(lItem.split(",")[0].toDouble(),lItem.split(",")[1].toDouble()))
                    } else if (tagname.equals("debut", ignoreCase = true)){
                        leVoyage.debut = LocalDate.parse(lItem, DateTimeFormatter.ofPattern("y-M-d"))
                    } else if (tagname.equals("fin", ignoreCase = true)){
                        leVoyage.fin = LocalDate.parse(lItem, DateTimeFormatter.ofPattern("y-M-d"))
                    } else if (tagname.equals("participants", ignoreCase = true)){

                    } else if (tagname.equals("etapes", ignoreCase = true)){

                    }
                }
                //println("---------- tag : $tagname --- event : $evtType ---- item : $lItem ----")
                evtType = parser.next()
            }
        }catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return lesVoyages
    }
}