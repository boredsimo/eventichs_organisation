package gti.g55.eventichs_organisation.Présentation.Présenteur


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Présenteur.EvenementViewHolder

class RecyclerViewAdapteurEvenement(var dataEvenement: List<Évènement>, @LayoutRes var layout: Int) :
    RecyclerView.Adapter<EvenementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvenementViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layout, parent, false)
        return EvenementViewHolder(view)
    }

    override fun onBindViewHolder(holder: EvenementViewHolder, position: Int) {
        holder.bindItem(dataEvenement[position])
    }

    override fun getItemCount(): Int {
        return dataEvenement.size
    }
}
