package gti.g55.eventichs_organisation

import android.location.Geocoder
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementAPI
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import java.io.IOException

class GoogleMapsFragment : Fragment() {

    private var zoomLevel = 11f
    lateinit var btnRetour: Button

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

        // To replace to format MVP
        val source = SourceÉvènementAPI()
        val events = source.récupérerListeÉvènements()

        for(event in events){
            var latlng = adresseToLatLng(event.addresse)
            if (latlng != null){
                googleMap.addMarker(MarkerOptions().position(latlng).title(event.nom))
            } else {
                println("Unable to get coordinates for the address: ${event.addresse}")
            }
        }

        val montreal = LatLng(45.50191163465637, -73.56739916710052)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(montreal, zoomLevel))
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
        btnRetour = view.findViewById(R.id.btnRetourMaps)

        btnRetour.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_googleMapsFragment_to_evenement)
        }
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