package fr.lapoumerole.nosvoyages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Etapes : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var bdlExtras: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etapes)
        bdlExtras = intent.extras

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val lePoint = LatLng(bdlExtras.getDouble("BaryLat"),bdlExtras.getDouble("BaryLon"))
        mMap.addMarker(MarkerOptions().position(lePoint).title(bdlExtras.getString("NomVoyage")))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lePoint, 5f))
    }
}
