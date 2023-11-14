package gti.g55.eventichs_organisation.Présentation.Modèle

import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionÉvènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement

class ModèleVueEvenement( val source: SourceÉvènement) {

        var ListeÉvènementCourante: ArrayList<Évènement> = ArrayList()

            fun RemplacerListeÉvènements(): List<Évènement>{
                Log.e("LOG", "OBTENIRLISTE GOT CALLED")
                var nouvelleListeEvenement = InteracteurAcquisitionÉvènement(source).obtenirNouvelleListeÉvènement()
                ListeÉvènementCourante = nouvelleListeEvenement

                return nouvelleListeEvenement
            }
}