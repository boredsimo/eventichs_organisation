package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Organisation

interface SourceOrganisation {
    fun récupérerListeOrganisations(): List<Organisation>
}