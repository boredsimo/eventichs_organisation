package gti.g55.eventichs_organisation.Présentation.Modèle

import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionÉvènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

class ModèleVueEvenement( val source: SourceÉvènement) {

        //lateinit var source2:SourceÉvènementBidon
        var ListeÉvènementCourante: ArrayList<Évènement> = ArrayList()

        fun RemplacerListeÉvènements(): List<Évènement>{
            Log.e("LOG", "OBTENIRLISTE GOT CALLED")
            var nouvelleListeEvenement = InteracteurAcquisitionÉvènement(source).obtenirNouvelleListeÉvènement()
            ListeÉvènementCourante = nouvelleListeEvenement

            return nouvelleListeEvenement
        }

        fun findEvenementByID(id: Int): Évènement{
            var nouvelleListeEvenement = InteracteurAcquisitionÉvènement(source).obtenirNouvelleListeÉvènement()
            Log.e("LOG", "findEvenementByID GOT CALLED $nouvelleListeEvenement")
            return nouvelleListeEvenement[id - 1]
        }

        fun remplacerElement(unEvenement:Évènement){
            val index =source.listeRetour.indexOfFirst { it.code==unEvenement.code }
            if (index != -1){
                source.listeRetour[index]=unEvenement
            }
            val test=source.listeRetour[index].nom
            val test2=source.listeRetour[3].nom

            Log.e("remplcer the event","$test")
            Log.e("remplcer the event","$test2")

        }






}