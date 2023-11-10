package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.R

/**
 * A simple [Fragment] subclass.
 * Use the [Evenement_detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class Evenement_detail : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var imagehome: ImageView

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagehome=view.findViewById(R.id.home)
        imagehome.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_evenement_detail_to_evenement)
        }
    }
}