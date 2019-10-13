package fr.lapoumerole.nosvoyages

import android.app.Application
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.io.IOException
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    internal inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {

        private val contents: View = layoutInflater.inflate(R.layout.custom_info_contents, null)
        private val window: View = layoutInflater.inflate(R.layout.custom_info_window, null)
        override fun getInfoWindow(marker: Marker): View? {

            return null
        }
        override fun getInfoContents(marker: Marker): View? {

            render(marker, contents)
            return contents
        }

        private fun render(marker: Marker, view: View) {

            val title: String? = marker.title
            val titleUi = view.findViewById<TextView>(R.id.title)

            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                titleUi.text = SpannableString(title).apply {
                    setSpan(ForegroundColorSpan(Color.RED), 0, length, 0)
                }
            } else {
                titleUi.text = ""
            }

            val leTag: Map<String,String> = marker.tag as Map<String,String>
            val debut: String? = leTag.getValue("DBT")
            val debutUi = view.findViewById<TextView>(R.id.debut)
            if (debut != null && debut.length > 5) {
                debutUi.text = SpannableString(debut).apply {
                    setSpan(ForegroundColorSpan(Color.MAGENTA), 0, 3, 0)
                    setSpan(ForegroundColorSpan(Color.BLUE), 4, debut.length, 0)
                }
            } else {
                debutUi.text = ""
            }
            val fin: String? = leTag.getValue("FIN")
            val finUi = view.findViewById<TextView>(R.id.fin)
            if (fin != null && fin.length > 5) {
                finUi.text = SpannableString(fin).apply {
                    setSpan(ForegroundColorSpan(Color.MAGENTA), 0, 3, 0)
                    setSpan(ForegroundColorSpan(Color.BLUE), 4, fin.length, 0)
                }
            } else {
                finUi.text = ""
            }
        }
    }

    public fun onInfoWindowClick(marker: Marker ) {
        val intent: Intent =  Intent(this, Etapes::class.java)
        intent.putExtra("NumVoyage",0)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        println("-----------------------------oncreate--------------------------")
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val laPoum = LatLng(45.960266, 2.681798)
        mMap.addMarker(MarkerOptions().position(laPoum).title("La Poumerole"))
        val rognes = LatLng(43.663014, 5.328914)
        mMap.addMarker(MarkerOptions().position(rognes).title("Rognes"))
        var nosVoyages = mutableListOf<Voyage>()
        try {
            val parser = ChargeurVoyage()
            val istream = assets.open("voyages.xml")
            nosVoyages = parser.parse(istream)
        } catch (e:IOException){
            e.printStackTrace()
        }

        for (leVoyage in nosVoyages){
            val mMrk = mMap.addMarker(MarkerOptions().position(leVoyage.barycentre.latlon).title(leVoyage.nom))
            mMrk.tag = mapOf(
                "DBT" to leVoyage.debut.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)),
                "FIN" to leVoyage.fin.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)),
                "ID" to leVoyage.id.toString()
                )
        }
        mMap.setInfoWindowAdapter(CustomInfoWindowAdapter())

        mMap.setOnInfoWindowClickListener {
            val leTag: Map<String,String> = it.tag as Map<String,String>
            val debut: String? = leTag.getValue("DBT")
            val fin: String? = leTag.getValue("FIN")
            val num:String? = leTag.getValue("ID")
                val intent =  Intent(this, Etapes::class.java)
                intent.putExtra("NumVoyage",num)
            intent.putExtra("NomVoyage", it.title)
            intent.putExtra("Debut", debut)
            intent.putExtra("Fin", fin)
            intent.putExtra("BaryLat", it.position.latitude)
            intent.putExtra("BaryLon", it.position.longitude)
            startActivity(intent)
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(laPoum,0f))
    }
}

