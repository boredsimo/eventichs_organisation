package gti.g55.eventichs_organisation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Acceuil.newInstance] factory method to
 * create an instance of this fragment.
 */
class Acceuil : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var btnVersEcran2:Button
    lateinit var btnVersCreationEvenement:Button

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
        return inflater.inflate(R.layout.fragment_acceuil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVersEcran2=view.findViewById(R.id.btnAcceuil)
        btnVersEcran2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_acceuil_to_evenement)
        }
        btnVersCreationEvenement = view.findViewById(R.id.btnCréation)
        btnVersCreationEvenement.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_acceuil_to_creerEvenement)
        }
    }
}