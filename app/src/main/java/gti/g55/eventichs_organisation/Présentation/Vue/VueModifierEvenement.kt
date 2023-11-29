package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésentateurModifierEvenement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementAPI
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

/**
 * A simple [Fragment] subclass.
 * Use the [evenement_modifier.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueModifierEvenement : Fragment() {
    private var _présenteur: PrésentateurModifierEvenement? = null
    lateinit var nomEvenement: TextView
    lateinit var dateDébut: TextView
    lateinit var dateFin: TextView
    lateinit var Addresse: TextView
    lateinit var imageversdétail: ImageView
    lateinit var btnSave: Button

    fun setPrésenteur(présenteurModifierEvenement: PrésentateurModifierEvenement){
        _présenteur = présenteurModifierEvenement
    }


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
        btnSave = view.findViewById(R.id.enregistrer)


        val selectedÉvènement = arguments?.getParcelable<Évènement>("Évènementmodifier")

        val listeEvenements = SourceÉvènementBidon().listeRetour

        nomEvenement.text=selectedÉvènement?.nom
        dateDébut.text=selectedÉvènement?.dateDebut
        dateFin.text=selectedÉvènement?.dateFin
        Addresse.text=selectedÉvènement?.addresse
        imageversdétail.setOnClickListener {
            //var eventToUpdate = listeEvenements.find { it.code == selectedÉvènement?.code }
            //if (eventToUpdate != null){
                //eventToUpdate.nom=nomEvenement.text.toString()
                //eventToUpdate.dateDebut=dateDébut.text.toString()
                //eventToUpdate.dateFin=dateFin.text.toString()
                //eventToUpdate.addresse=Addresse.text.toString()
            //}

            Navigation.findNavController(view)
                .navigate(R.id.action_vueModifierEvenement_to_evenement_detail)
        }

        btnSave.setOnClickListener {
            _présenteur!!.saveEvenement(selectedÉvènement!!.code, nomEvenement.text.toString(), dateDébut.text.toString(), dateFin.text.toString(), Addresse.text.toString())
        }

        val modèle = ModèleVueEvenement(SourceÉvènementAPI())
        _présenteur = PrésentateurModifierEvenement(this, modèle)
        setPrésenteur(_présenteur!!)



    }


}