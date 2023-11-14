package gti.g55.eventichs_organisation


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement_detail
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

class RecyclerViewAdapteurEvenement(var dataEvenement: List<Évènement>, @LayoutRes var layout: Int) :
    RecyclerView.Adapter<evenementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): evenementViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layout, parent, false)
        return evenementViewHolder(view)
    }

    override fun onBindViewHolder(holder: evenementViewHolder, position: Int) {
        holder.bindItem(dataEvenement[position])
    }

    override fun getItemCount(): Int {
        return dataEvenement.size
    }
}
