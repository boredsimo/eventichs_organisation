package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement

interface SourceÉvènement {

        fun récupérerListeÉvènements(): List<Évènement>

        fun modifierÉvénements(Listecourante:List<Évènement>)

}
