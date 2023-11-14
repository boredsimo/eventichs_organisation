package gti.g55.eventichs_organisation.Présentation.Vue

import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.R


/**
 * A simple [Fragment] subclass.
 * Use the [VueEvenement_detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueEvenement_detail : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var imagehome: ImageView
    lateinit var text:TextView
    var Titre:String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val bundle = Bundle()
            Titre= bundle.getString("nomevent")
            println(Titre)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        container?.clearDisappearingChildren()
        return inflater.inflate(R.layout.fragment_evenement_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagehome=view.findViewById(R.id.home)
        text=view.findViewById(R.id.Titre)
        text.text=Titre
        imagehome.setOnClickListener{
            Log.d("dsknso","nvsnfvknwefnv")
            Navigation.findNavController(view).navigate(R.id.action_evenement_detail_to_creerEvenement)
        }
    }
}