package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.RecyclerViewAdapteurEvenement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import androidx.appcompat.widget.SearchView;
import gti.g55.eventichs_organisation.evenementViewHolder


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
    //to be replaced
    private var btnVersDétailévénement: Button? = null
    private var btnVersGoogleMaps: Button? = null
    private var recyclerView: RecyclerView? = null
    private var dataEvenement: List<Évènement>? = null
    private var recyclerAdapter: RecyclerViewAdapteurEvenement? = null
    private var unEvenement: Évènement? = null
    lateinit var searchView: SearchView // Using private var completely breaks it

    // TODO DELETE THIS AND REPLACE WITH ACTUAL MVP
    val sourceBidon = SourceÉvènementBidon()

    fun setPrésenteur(présenteurEvenement: PrésenteurEvenement?){
        _présenteur = présenteurEvenement
    }
    

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evenement, container, false)
    }

    override fun onViewCreated(vue: View, savedInstanceState: Bundle?) {
        super.onViewCreated(vue, savedInstanceState)
        btnVersProfil=vue.findViewById(R.id.buttonVersProfil)
        btnVersCréerEvénement=vue.findViewById(R.id.bouttonVersCréer)
        btnVersCréerEvénement=vue.findViewById(R.id.bouttonVersCréer)
        // to be replaced
        //btnVersDétailévénement=vue.findViewById(R.id.bouttonVersDétail)
        btnVersGoogleMaps = vue.findViewById(R.id.goToMaps)
        recyclerView = vue.findViewById(R.id.recyclerViewEvenements)
        searchView = vue.findViewById(R.id.search)

        btnVersCréerEvénement?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_creerEvenement)
        }
        btnVersDétailévénement?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_evenement_detail)
        }

        btnVersProfil?.setOnClickListener {
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_ecranProfil)
        }

        btnVersGoogleMaps?.setOnClickListener{
            Navigation.findNavController(vue).navigate(R.id.action_evenement_to_googleMapsFragment)
        }

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

        dataEvenement = sourceBidon.récupérerListeÉvènements()
        afficherRecyclerView(dataEvenement!!)

        _présenteur?.rafraichirListeÉvènements()

    }

    //TO BE RAPLACE -- ONCE WE GET ANDY'S RECYCLERVIEW
    fun remplacerÉvènementViaMVP(event: Évènement){
        btnVersDétailévénement?.setText(event.nom)
    }

    // Recherche par nom
    private fun searchList(text: String) {
        val dataSearchÉvènement = mutableListOf<Évènement>()

        for (évènement in dataEvenement!!) {
            if (évènement.nom.lowercase().contains(text.lowercase())) {
                dataSearchÉvènement.add(évènement)
            }
        }

        afficherRecyclerView(dataSearchÉvènement)
    }

    fun afficherRecyclerView(dataEvenement: List<Évènement>){
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerAdapter = RecyclerViewAdapteurEvenement(dataEvenement, R.layout.recycler_item)
        recyclerView?.adapter = recyclerAdapter
    }
}