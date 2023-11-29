package gti.g55.eventichs_organisation.sourceDeDonnées

import android.util.Log
import dti.g55.chargeur.sourceDeDonnées.DécodeurJsonÉvénement
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

class SourceÉvènementAPI: SourceÉvènement {
    override var listeRetour: ArrayList<Évènement> = ArrayList()
    val url = "http://v34l.com:8080/"

    val client = OkHttpClient()

    override fun récupérerListeÉvènements(): List<Évènement> {
        var request = Request.Builder()
            .url("http://v34l.com:8080/evenements")
            .build()

        var reponse = client.newCall(request).enqueue(object: Callback{



            override fun onFailure(call: Call, e: IOException) {
                Log.e("Return listeEvenement", "Womp womp")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    // Handle successful response here
                    val responseData = response.body?.string()
                    listeRetour = DécodeurJsonÉvénement.décoderJsonVersÉvénements(responseData.toString()) as ArrayList<Évènement>
                } else {
                    // Handle unsuccessful response here
                }
            }
        })

        return listeRetour
    }


    override fun ajouterÉvènement(evenement: Évènement) {
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()

        val jsonObject = JSONObject()

        jsonObject.put("id", evenement.code)
        jsonObject.put("nom", evenement.nom)
        jsonObject.put("adresse", evenement.addresse)
        jsonObject.put("dateDebut", evenement.dateDebut)
        jsonObject.put("dateFin", evenement.dateFin)
        jsonObject.put("type", "public")
        jsonObject.put("categorie", "Party")
        jsonObject.put("description", evenement.description)
        jsonObject.put("image", "explosion.jpg")
        jsonObject.put("organisation", "Rosemont")

        val requestBody = jsonObject.toString().toRequestBody(JSON)

        val request = Request.Builder()
            .url("http://v34l.com:8080/evenements")
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", "fatal error caught")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    Log.e("response", response.code.toString())
                } else {
                    Log.e("response", response.code.toString())
                }
            }
        })
    }

    override fun modifierÉvénements(Listecourante: List<Évènement>) {
        TODO("Not yet implemented")
    }

}