package gti.g55.eventichs_organisation

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement

class evenementViewHolder (@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {

    val item: LinearLayout
    var recTitle: TextView
    var recHeure: TextView
    init {
        item = itemView.findViewById(R.id.recyclerItemId)
        recTitle = itemView.findViewById(R.id.recTitle)
        recHeure = itemView.findViewById(R.id.recHeure)
    }


    fun goToFragment(item: LinearLayout){
        item.findNavController().navigate(R.id.action_evenement_to_evenement_detail)
    }

    fun bindItem(unEvenement: Évènement){
        recTitle.text = unEvenement.nom
        recHeure.text = unEvenement.dateDebut

        item.setOnClickListener {
            goToFragment(item)
        }
    }
}