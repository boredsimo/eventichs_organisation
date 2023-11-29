package dti.g55.chargeur.sourceDeDonnées

import android.util.JsonReader
import java.io.StringReader
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement

class DécodeurJsonÉvénement {
    companion object {

        fun décoderJsonVersÉvénements(json: String): List<Évènement> {
            val reader = JsonReader(StringReader(json))
            val événements = mutableListOf<Évènement>()

            reader.beginArray()
            while (reader.hasNext()) {
                événements.add(décoderJsonVersÉvénement(reader))
            }
            reader.endArray()

            return événements
        }

        fun décoderJsonVersÉvénement(json: String): Évènement {
            val reader = JsonReader(StringReader(json))
            return décoderJsonVersÉvénement(reader)
        }

        fun décoderJsonVersÉvénement(reader: JsonReader): Évènement {
            var id = 0
            var nom = ""
            var adresse = ""
            var dateDebut = ""
            var dateFin = ""
            var type = ""
            var catégorie = ""
            var description = ""
            var image = ""
            var organisation = ""

            reader.beginObject()
            while (reader.hasNext()) {
                val clé = reader.nextName()
                when (clé) {
                    "id" -> id = reader.nextInt()
                    "nom" -> nom = reader.nextString()
                    "adresse" -> adresse = reader.nextString()
                    "dateDebut" -> dateDebut = reader.nextString()
                    "dateFin" -> dateFin = reader.nextString()
                    "type" -> type = reader.nextString()
                    "categorie" -> catégorie = reader.nextString()
                    "description" -> description = reader.nextString()
                    "image" -> image = reader.nextString()
                    "organisation" -> organisation = reader.nextString()
                    else -> reader.skipValue()
                }
            }
            reader.endObject()

            return Évènement(id, nom, dateDebut, dateFin, description,adresse, type, 1)
        }
    }
}
