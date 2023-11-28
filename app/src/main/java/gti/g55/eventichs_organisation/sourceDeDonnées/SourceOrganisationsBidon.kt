package gti.g55.eventichs_organisation.sourceDeDonnées

import gti.g55.eventichs_organisation.Domaine.Entités.Organisation
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceOrganisation

class SourceOrganisationsBidon: SourceOrganisation {
    var listeRetour: ArrayList<Organisation> = ArrayList()

    override fun récupérerListeOrganisations(): List<Organisation> {

        listeRetour.add(
            Organisation(
                1,
                1,
                1,
                "Organisation 1",
                true
            )
        )
        listeRetour.add(
            Organisation(
                2,
                2,
                2,
                "Organisation 2",
                false
            )
        )
        listeRetour.add(
            Organisation(
                3,
                3,
                3,
                "Organisation 3",
                true
            )
        )
    return listeRetour
    }
}