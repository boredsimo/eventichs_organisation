package gti.g55.eventichs_organisation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [evenement_modifier.newInstance] factory method to
 * create an instance of this fragment.
 */
class evenement_modifier : Fragment() {
    lateinit var nomEvenement:TextView
    lateinit var dateDébut:TextView
    lateinit var dateFin:TextView
    lateinit var Addresse:TextView
    lateinit var imageversdétail:ImageView


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
        return inflater.inflate(R.layout.fragment_evenement_modifier, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nomEvenement=view.findViewById(R.id.nomevenermt)
        dateDébut=view.findViewById(R.id.dateDebut)
        dateFin=view.findViewById(R.id.datefin)
        Addresse=view.findViewById(R.id.addresse)
        imageversdétail=view.findViewById(R.id.btn_versdétailback)


        val selectedÉvènement = arguments?.getParcelable<Évènement>("Évènementmodifier")



        nomEvenement.text=selectedÉvènement?.nom
        dateDébut.text=selectedÉvènement?.dateDebut
        dateFin.text=selectedÉvènement?.dateFin
        Addresse.text=selectedÉvènement?.addresse
        imageversdétail.setOnClickListener {
            var eventToUpdate=SourceÉvènementBidon().listeRetour.find { it.nom== selectedÉvènement?.nom}
            if (eventToUpdate != null){
                eventToUpdate.nom=nomEvenement.text.toString()
                eventToUpdate.dateDebut=dateDébut.text.toString()
                eventToUpdate.dateFin=dateFin.text.toString()
                eventToUpdate.addresse=Addresse.text.toString()
            }

            Navigation.findNavController(view).navigate(R.id.action_evenement_modifier_to_evenement_detail)
        }



    }


}