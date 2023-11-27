package gti.g55.eventichs_organisation.Présentation.Vue

import android.app.DatePickerDialog
import androidx.fragment.app.Fragment
import gti.g55.eventichs_organisation.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurCréation
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class VueCreation : Fragment() {
    // TODO: Rename and change types of parameters
    private var _présenteur: PrésenteurCréation? = null
    private var fieldNomEvenement: EditText? = null
    private var switchEvenementPrivé: Switch? = null
    private var fieldAddresseEvenement: EditText? = null
    private var fieldDescriptionEvenement: EditText? = null
    private var btnDateDebut: Button? = null
    private var btnDateFin: Button? = null
    private var btnSubmit: Button? = null
    private var textDateDebut: TextView? = null
    private var textDateFin: TextView? = null

    lateinit var btnVersAcceuil: Button

    val sourceBidon = SourceÉvènementBidon()

    fun setPrésenteur(PrésenteurCréation: PrésenteurCréation?) {
        _présenteur = PrésenteurCréation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_creer, container, false)

        fieldNomEvenement = vue.findViewById(R.id.fieldNomEvenement) // whyyy
        switchEvenementPrivé = vue.findViewById(R.id.switchEvenementPrivé)
        fieldAddresseEvenement = vue.findViewById(R.id.AddresseEvenement)
        fieldDescriptionEvenement = vue.findViewById(R.id.DescriptionEvenement)
        btnDateDebut = vue.findViewById(R.id.btnDateDebut)
        textDateDebut = vue.findViewById(R.id.textDateDébut)
        btnDateFin = vue.findViewById(R.id.btnDateFin)
        textDateFin = vue.findViewById(R.id.textDateFin)
        btnSubmit = vue.findViewById(R.id.btnSubmit)
        btnVersAcceuil = vue.findViewById(R.id.btnRetourAcceuil)

        btnVersAcceuil?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_creerEvenement_to_evenement)
        }


        //calls the DatePickerDialog
        //on date submit, it will modify
        //btnSubmit?.setOnClickListener {
        //    _présenteur?.ajouterÉvènement()
        //}

        btnDateDebut?.setOnClickListener {

//            val currentDate = Calendar.getInstance()
//            val DatePicker = DatePickerDialog(requireContext())
//
//            DatePicker.datePicker.minDate = currentDate.timeInMillis
//
//            DatePicker.setOnDateSetListener { DatePicker, year, month, day, ->
//                val selectedDate = Calendar.getInstance()
//                selectedDate.set(year, month, day)
//
//
//            }

            _présenteur?.changerDateDébut(DatePickerDialog(requireContext()))
        }


        return inflater.inflate(R.layout.fragment_creer, container, false)
    }

    fun changerDateDébut(format: String) {
        textDateDebut?.setText(format)
    }
}

