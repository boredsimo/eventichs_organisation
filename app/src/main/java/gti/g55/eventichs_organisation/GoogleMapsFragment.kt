package gti.g55.eventichs_organisation

import android.location.Geocoder
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import java.io.IOException

class GoogleMapsFragment : Fragment() {

    private var zoomLevel = 15f

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        // To replace
        val sourceBidon = SourceÉvènementBidon()
        val events = sourceBidon.récupérerListeÉvènements()

        for(event in events){
            var latlng = adresseToLatLng(event.addresse)
            if (latlng != null){
                googleMap.addMarker(MarkerOptions().position(latlng).title(event.nom))
            } else {
                println("Unable to get coordinates for the address: ${event.addresse}")
            }
        }

        val rosemont = LatLng(45.55730452222236, -73.5822902031885)
        googleMap.addMarker(MarkerOptions().position(rosemont).title("Collège de Rosemont"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rosemont, zoomLevel))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_google_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    fun adresseToLatLng(adresse: String): LatLng? {
        val geocoder = Geocoder(requireContext())
        try{
            val adresses = geocoder.getFromLocationName(adresse, 1)
            if(adresses?.isNotEmpty() == true){
                val latitude = adresses[0].latitude
                val longitude = adresses[0].longitude
                return LatLng(latitude, longitude)
            }
        } catch (e: IOException){
            e.printStackTrace()
        }
        return null
    }
}