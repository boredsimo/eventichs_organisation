package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Utilisateur

interface SourceUtilisateur {

    fun récupérerListeUtilisateurs(): List<Utilisateur>
}