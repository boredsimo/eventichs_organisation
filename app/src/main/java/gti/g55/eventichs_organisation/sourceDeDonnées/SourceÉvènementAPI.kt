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
import okhttp3.internal.wait
import okio.IOException
import org.json.JSONObject

class SourceÉvènementAPI: SourceÉvènement {
    override var listeRetour: ArrayList<Évènement> = ArrayList()
    val url = "http://v34l.com:8080/"

    val client = OkHttpClient()

    override fun récupérerListeÉvènements(): List<Évènement> {
        var request = Request.Builder()
            .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlBNDRET0VwQTNYMUw2bUhESG8tWiJ9.eyJpc3MiOiJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2NTZkMmRiZWExOTU5OWM5MjA5YTRmMDEiLCJhdWQiOlsiaHR0cDovL2V2ZW50aWNocy5hcGkiLCJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE3MDMxOTk5MzEsImV4cCI6MTcwMzI4NjMzMSwiYXpwIjoibFdpa3dMRzJVa01Yb0N2TG9hNHo3QUdBUldPQ1BaaXYiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIGFkZHJlc3MgcGhvbmUiLCJndHkiOiJwYXNzd29yZCJ9.isCqhobaR7Ao1miGDRLR6We9Vkkw9pJZ2HLEXbULafD1E41PR-vKgffC2kIFwodjPsZUmUh2Y4f55DRYvRTkF9Ou7iT4HeAL8AAEktCzw6pHJSw1zj9hLrgearqERBz1CBx-GHKsM2JWuuiJLMLssOC-3OpdlbzchCe85DxquHPhk8egHDipdBaxY66EwCCghlHwejQNw2DXdcbzfS00evPgzBknaBagHR3LVXW-zt3NLJi9o_7pprEK-5V8UW6HdpRGgxRlMEZ9UkWska2fhs11kZlFN99-AxNekW2LAmdcOQm-__YYIbecILpsGa19Zq-mMsOoukk8ajDj6QCsiQ")
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
        Thread.sleep(500)
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
            .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlBNDRET0VwQTNYMUw2bUhESG8tWiJ9.eyJpc3MiOiJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2NTZkMmRiZWExOTU5OWM5MjA5YTRmMDEiLCJhdWQiOlsiaHR0cDovL2V2ZW50aWNocy5hcGkiLCJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE3MDMxOTk5MzEsImV4cCI6MTcwMzI4NjMzMSwiYXpwIjoibFdpa3dMRzJVa01Yb0N2TG9hNHo3QUdBUldPQ1BaaXYiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIGFkZHJlc3MgcGhvbmUiLCJndHkiOiJwYXNzd29yZCJ9.isCqhobaR7Ao1miGDRLR6We9Vkkw9pJZ2HLEXbULafD1E41PR-vKgffC2kIFwodjPsZUmUh2Y4f55DRYvRTkF9Ou7iT4HeAL8AAEktCzw6pHJSw1zj9hLrgearqERBz1CBx-GHKsM2JWuuiJLMLssOC-3OpdlbzchCe85DxquHPhk8egHDipdBaxY66EwCCghlHwejQNw2DXdcbzfS00evPgzBknaBagHR3LVXW-zt3NLJi9o_7pprEK-5V8UW6HdpRGgxRlMEZ9UkWska2fhs11kZlFN99-AxNekW2LAmdcOQm-__YYIbecILpsGa19Zq-mMsOoukk8ajDj6QCsiQ")
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

    override fun modifierÉvénements(evenement: Évènement) {
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()

        val jsonObject = JSONObject()

        jsonObject.put("id", evenement.code)
        Log.e("tag",evenement.code.toString())
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
            .url("http://v34l.com:8080/evenements/"+evenement.code)
            .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlBNDRET0VwQTNYMUw2bUhESG8tWiJ9.eyJpc3MiOiJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2NTZkMmRiZWExOTU5OWM5MjA5YTRmMDEiLCJhdWQiOlsiaHR0cDovL2V2ZW50aWNocy5hcGkiLCJodHRwczovL2Rldi14YTJmNnFjcmI3a2FwMzNuLnVzLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE3MDMxOTk5MzEsImV4cCI6MTcwMzI4NjMzMSwiYXpwIjoibFdpa3dMRzJVa01Yb0N2TG9hNHo3QUdBUldPQ1BaaXYiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIGFkZHJlc3MgcGhvbmUiLCJndHkiOiJwYXNzd29yZCJ9.isCqhobaR7Ao1miGDRLR6We9Vkkw9pJZ2HLEXbULafD1E41PR-vKgffC2kIFwodjPsZUmUh2Y4f55DRYvRTkF9Ou7iT4HeAL8AAEktCzw6pHJSw1zj9hLrgearqERBz1CBx-GHKsM2JWuuiJLMLssOC-3OpdlbzchCe85DxquHPhk8egHDipdBaxY66EwCCghlHwejQNw2DXdcbzfS00evPgzBknaBagHR3LVXW-zt3NLJi9o_7pprEK-5V8UW6HdpRGgxRlMEZ9UkWska2fhs11kZlFN99-AxNekW2LAmdcOQm-__YYIbecILpsGa19Zq-mMsOoukk8ajDj6QCsiQ")
            .put(requestBody)
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

    override fun findÉvènementById(id: Int): Évènement {
        var request = Request.Builder()
            .url("http://v34l.com:8080/evenements/"+id)
            .build()

        var reponse = client.newCall(request).enqueue(object: Callback{



            override fun onFailure(call: Call, e: IOException) {
                Log.e("Return listeEvenement", "Womp womp")
            }

            override fun onResponse(call: Call, response: Response) {

                if (response.isSuccessful) {
                    // Handle successful response here

                    val responseData = response.body?.string()
                    listeRetour.add(DécodeurJsonÉvénement.décoderJsonVersÉvénement(responseData.toString()))
                } else {
                    // Handle unsuccessful response here
                }
            }
        })
        Log.e("is it here?", "why")
        Thread.sleep(1000)
        return listeRetour[0]
    }

}