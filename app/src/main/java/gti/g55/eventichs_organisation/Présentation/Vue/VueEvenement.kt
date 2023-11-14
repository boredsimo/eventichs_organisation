package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.RecyclerViewAdapteurEvenement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import androidx.appcompat.widget.SearchView;
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import gti.g55.eventichs_organisation.evenementViewHolder

/**
 * A simple [Fragment] subclass.
 * Use the [VueEvenement.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueEvenement : Fragment() {
    private var _présenteur: PrésenteurEvenement? = null
    lateinit var btnVersProfil: Button
    lateinit var btnVersCréerEvénement: Button
    //lateinit var btnVersDétailévénement: Button
    lateinit var btnVersGoogleMaps: Button
    lateinit var recyclerView: RecyclerView


    //no data allowed :(
    lateinit var dataEvenement: List<Évènement>
    lateinit var recyclerAdapter: RecyclerViewAdapteurEvenement
    lateinit var unEvenement: Évènement
    lateinit var searchView: SearchView


    fun setPrésenteur(présenteurEvenement: PrésenteurEvenement){
        _présenteur = présenteurEvenement
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
        return inflater.inflate(R.layout.fragment_evenement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVersProfil=view.findViewById(R.id.buttonVersProfil)
        btnVersCréerEvénement=view.findViewById(R.id.bouttonVersCréer)
        btnVersGoogleMaps = view.findViewById(R.id.goToMaps)

        recyclerView = view.findViewById(R.id.recyclerViewEvenements)
        searchView = requireView().findViewById(R.id.search)

        btnVersProfil.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_ecranProfil)
        }
        btnVersCréerEvénement.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_creerEvenement)
        }

        btnVersGoogleMaps.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_evenement_to_googleMapsFragment)
        }


        val modèle = ModèleVueEvenement(SourceÉvènementBidon())
        _présenteur = PrésenteurEvenement(this, modèle) // Assuming "this" refers to VueEvenement


        setPrésenteur(_présenteur!!)

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    searchList(newText)
                }
                return true
            }
        })

        _présenteur?.rafraichirListeÉvènements()



    }

    // Recherche par nom
    private fun searchList(text: String) {
        val dataSearchÉvènement = mutableListOf<Évènement>()

        for (évènement in dataEvenement) {
            if (évènement.nom.lowercase().contains(text.lowercase())) {
                dataSearchÉvènement.add(évènement)
            }
        }

        afficherRecyclerView(dataSearchÉvènement)
    }

    fun afficherRecyclerView(dataEvenement: List<Évènement>){
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.layoutManager = gridLayoutManager
        recyclerAdapter = RecyclerViewAdapteurEvenement(dataEvenement, R.layout.recycler_item)
        recyclerView.adapter = recyclerAdapter
    }
}