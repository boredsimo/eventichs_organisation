package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.R

/**
 * A simple [Fragment] subclass.
 * Use the [VueEvenement.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueEvenement : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var btnVersProfil: Button
    lateinit var btnVersCréerEvénement: Button
    lateinit var btnVersDétailévénement: Button
    lateinit var btnVersGoogleMaps: Button

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
        return inflater.inflate(R.layout.fragment_evenement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVersProfil=view.findViewById(R.id.buttonVersProfil)
        btnVersCréerEvénement=view.findViewById(R.id.bouttonVersCréer)
        btnVersDétailévénement=view.findViewById(R.id.bouttonVersDétail)
        btnVersGoogleMaps = view.findViewById(R.id.goToMaps)

        btnVersProfil.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_ecranProfil)
        }
        btnVersCréerEvénement.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_creerEvenement)
        }
        btnVersDétailévénement.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_evenement_detail)
        }

        btnVersGoogleMaps.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_googleMapsFragment)
        }

    }
}