package gti.g55.eventichs_organisation.Présentation.Vue

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.R

/**
 * A simple [Fragment] subclass.
 * Use the [VueEvenement_detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueEvenement_detail : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var imagehome: ImageView
    lateinit var textViewNom: TextView
    lateinit var versMaps:Button
    lateinit var textDateDebut: TextView
    lateinit var textDateFin: TextView
    lateinit var textAdresse: TextView
    lateinit var textDescription: TextView
    lateinit var imagemodifier:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evenement_detail, container, false)
    }

    //inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
        //SDK_INT >= 33 -> getParcelable("Évènement", T::class.java)
        //else -> @Suppress("DEPRECATION") getParcelable(key) as? T
    //}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedÉvènement = arguments?.getParcelable<Évènement>("Évènement")
        imagehome=view.findViewById(R.id.btn_versdétailback)
        textViewNom = view.findViewById(R.id.nomEvent)
        versMaps=view.findViewById(R.id.verxmaps)
        textDateDebut=view.findViewById(R.id.dateDebEvent)
        textDateFin=view.findViewById(R.id.dateFinEvent)
        textAdresse=view.findViewById(R.id.adresseEvent)
        textDescription=view.findViewById(R.id.descriptionEvent)
        imagemodifier=view.findViewById(R.id.btnvers_modifier)


        versMaps.setOnClickListener {
            val address = selectedÉvènement?.addresse // Replace with the desired address
            val encodedAddress = Uri.encode(address)
            val gmmIntentUri = "geo:0,0?q=$encodedAddress"
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(gmmIntentUri))
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(requireContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show()
            }
        }
        val event = selectedÉvènement
        val bundle = Bundle().apply {
            putParcelable("Évènementmodifier", event)
        }
        imagehome.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_evenement_detail_to_evenement)
        }
        imagemodifier.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_detail_to_evenement_modifier)
        }

        var eventNom = selectedÉvènement?.nom
        if (eventNom != null){
            textViewNom.text = eventNom
        }
        var eventDateDebut = selectedÉvènement?.dateDebut
        if (eventDateDebut != null){
            textDateDebut.text = eventDateDebut
        }
        var eventDateFin = selectedÉvènement?.dateFin
        if (eventDateFin != null) {
            textDateFin.text = eventDateFin
        }
        var eventAdresse = selectedÉvènement?.addresse
        if (eventAdresse != null){
            textAdresse.text = eventAdresse
        }
        var eventDescription = selectedÉvènement?.description
        if (eventDateDebut != null){
            textDescription.text = eventDescription
        }
    }
}
