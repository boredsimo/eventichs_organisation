package gti.g55.eventichs_organisation


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement_detail

class RecyclerViewAdapteurEvenement(private val context: VueEvenement,
                                    private var dataEvenement: List<Évènement>) :

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
        holder.bind(unEvenement)
        holder.itemView.setOnClickListener {


                val activity = it.context as AppCompatActivity
                val fragmentDetail = VueEvenement_detail()

                // Log the message
                Log.d("YourTag", "Item at position 1 clicked")
                val bundle=Bundle()
                bundle.putString("nomevent",dataEvenement[position].nom)

                // Replace fragment
            activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.rec, fragmentDetail)
                    .addToBackStack(null)
                    .commit()

        }
    }


    override fun getItemCount(): Int {
        return dataEvenement.size
    }
}

class MyViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recTitle: TextView = itemView.findViewById(R.id.recTitle)
    var recHeure: TextView = itemView.findViewById(R.id.recHeure)
    fun bind(item:Évènement){
        recTitle.text=item.nom
        recHeure.text=item.dateDebut
    }
}
