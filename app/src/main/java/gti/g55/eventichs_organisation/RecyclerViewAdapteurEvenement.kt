package gti.g55.eventichs_organisation


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement_detail

class RecyclerViewAdapteurEvenement(private val context: VueEvenement, private var dataEvenement: List<Évènement>) :
    RecyclerView.Adapter<MyViewHolder>() {

    fun setSearchList(rechercheEvenement: List<Évènement>){
        this.dataEvenement = rechercheEvenement
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val unEvenement = dataEvenement[position]
        holder.recTitle.text = unEvenement.nom
        holder.recHeure.text = unEvenement.dateDebut

    }

    override fun getItemCount(): Int {
        return dataEvenement.size
    }
}

class MyViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    val recTitle: TextView = itemView.findViewById(R.id.recTitle)
    val recHeure: TextView = itemView.findViewById(R.id.recHeure)
    val evenementCarte: CardView = itemView.findViewById(R.id.evenementCard)
}
