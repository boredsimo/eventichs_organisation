package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement

interface SourceÉvènement {
        var listeRetour: ArrayList<Évènement>


        fun récupérerListeÉvènements(): List<Évènement>

        fun ajouterÉvènement(evenement: Évènement)

        fun modifierÉvénements(evenement: Évènement)

}
