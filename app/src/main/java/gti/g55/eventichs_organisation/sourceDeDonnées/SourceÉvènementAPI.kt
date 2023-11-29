package gti.g55.eventichs_organisation.sourceDeDonnées

import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException

class SourceÉvènementAPI: SourceÉvènement {
    override var listeRetour: ArrayList<Évènement> = ArrayList()
    val url = "http://v34l.com:8080/"

    val client = OkHttpClient()

    override fun récupérerListeÉvènements(): List<Évènement> {
        Log.i("Return body", "call started!")
        var request = Request.Builder()
            .url("http://v34l.com:8080/evenements")
            .build()

        var reponse = client.newCall(request).enqueue(object: Callback{



            override fun onFailure(call: Call, e: IOException) {
                Log.e("Return body", "Womp womp...")

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    // Handle successful response here
                    val responseData = response.body?.string()
                    Log.e("Return body", responseData.toString())
                    // Process responseData as needed
                } else {
                    // Handle unsuccessful response here
                }
            }
        })





        return listeRetour
    }

    override fun ajouterÉvènement(evenement: Évènement) {
        TODO("Not yet implemented")
    }

    override fun modifierÉvénements(Listecourante: List<Évènement>) {
        TODO("Not yet implemented")
    }

}