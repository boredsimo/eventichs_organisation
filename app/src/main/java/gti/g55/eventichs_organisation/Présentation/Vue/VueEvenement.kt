package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import gti.g55.eventichs_organisation.R

/**
 * A simple [Fragment] subclass.
 * Use the [VueEvenement.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueEvenement : Fragment() {
    // TODO: Rename and change types of parameters
    private var _présenteur: PrésenteurEvenement? = null
    private var btnVersProfil: Button? = null
    private var btnVersCréerEvénement: Button? = null
    private var btnVersDétailévénement: Button? = null
    private var btnVersGoogleMaps: Button? = null

    fun setPrésenteur(présenteurEvenement: PrésenteurEvenement?){
        _présenteur = présenteurEvenement
    }


    //testing mvp dw about it
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue =  inflater.inflate(R.layout.fragment_evenement, container, false)
        btnVersProfil=vue.findViewById(R.id.buttonVersProfil)
        btnVersCréerEvénement=vue.findViewById(R.id.bouttonVersCréer)
        btnVersCréerEvénement=vue.findViewById(R.id.bouttonVersCréer)
        btnVersDétailévénement=vue.findViewById(R.id.bouttonVersDétail)
        btnVersGoogleMaps = vue.findViewById(R.id.goToMaps)

        Log.e("HEYO","aboutToCrash?")
        btnVersCréerEvénement?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_creerEvenement)
        }
        btnVersDétailévénement?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_evenement_detail)
        }

        btnVersGoogleMaps?.setOnClickListener{
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_googleMapsFragment)
        }
        btnVersProfil?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_ecranProfil)
        }
        _présenteur?.rafraichirListeÉvènements()
        return vue
    }

    //TO BE RAPLACE -- ONCE WE GET ANDY'S RECYCLERVIEW
    fun remplacerÉvènementViaMVP(event: Évènement){
        btnVersDétailévénement?.setText(event.nom)
    }



// testing mvp dw about it
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//    }

}