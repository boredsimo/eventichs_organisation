package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Organisation

class InteracteurAcquisitionOrganisation(var source: SourceOrganisation) {
    private var _ListeOrganisation: ArrayList<Organisation> = ArrayList()

    @get:Throws(OrganisationException::class)
    val organisation: ArrayList<Organisation>
        get() = _ListeOrganisation

    @Throws(OrganisationException::class)
    fun obtenirNouvelleListeOrganisation(): ArrayList<Organisation> {
        var nouvelleListeOrganisation = source.récupérerListeOrganisations()
        while (nouvelleListeOrganisation == _ListeOrganisation) {
            nouvelleListeOrganisation = source.récupérerListeOrganisations()
            break
        }
        _ListeOrganisation = nouvelleListeOrganisation as ArrayList<Organisation>
        return _ListeOrganisation
    }
}