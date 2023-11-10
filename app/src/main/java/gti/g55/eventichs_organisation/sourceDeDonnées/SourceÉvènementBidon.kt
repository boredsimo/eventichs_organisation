package gti.g55.eventichs_organisation.sourceDeDonnées

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import kotlin.random.Random
import kotlin.random.nextInt

class SourceÉvènementBidon : SourceÉvènement {

    override fun récupérerListeÉvènements(): List<Évènement> {
        var listeRetour: ArrayList<Évènement> = ArrayList()

        while(listeRetour.size <= 10){
            if(Random.nextInt(2) == 0){
                listeRetour.add(Évènement(1,"Grève Générale Illimitée","21 Novembre 2023 à 08:00","23 Novembre 2023 à 08:00","Public",1))
            } else {
                listeRetour.add(Évènement(2,"Group sex","24 Novembre 2023 à 08:00","24 Novembre 2023 à 14:00","Public",1))
            }

        }

        return listeRetour

    }

}