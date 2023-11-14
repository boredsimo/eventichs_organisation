package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        imagehome=view.findViewById(R.id.home)
        textViewNom = view.findViewById(R.id.nomEvent)

        imagehome.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_evenement_detail_to_evenement)
        }

        var eventNom = selectedÉvènement?.nom
        if (eventNom != null){
            textViewNom.text = eventNom
        }




    }
}
