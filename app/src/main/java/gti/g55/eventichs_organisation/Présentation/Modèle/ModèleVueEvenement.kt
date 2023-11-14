package gti.g55.eventichs_organisation.Présentation.Modèle

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionÉvènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement

class ModèleVueEvenement( val source: SourceÉvènement) {
        var ListeÉvènementCourante: ArrayList<Évènement> = ArrayList()

            fun ObtenirListeÉvènements(): List<Évènement>{
                val nouvelleListeEvenement = InteracteurAcquisitionÉvènement(source).obtenirNouvelleListeÉvènement()
                //ListeÉvènementCourante

                return nouvelleListeEvenement
            }
}