package gti.g55.eventichs_organisation.Domaine.Interacteurs

import gti.g55.eventichs_organisation.Domaine.Entités.Utilisateur

class InteracteurAcquisitionUtilisateur(var source: SourceUtilisateur) {

    private var _ListeUtilisateur: ArrayList<Utilisateur> = ArrayList()

    @get:Throws(UtilisateurException::class)
    val utilisateur: ArrayList<Utilisateur>
        get() = _ListeUtilisateur

    @Throws(UtilisateurException::class)
    fun obtenirNouvelleListeUtilisateur(): ArrayList<Utilisateur> {
        var nouvelleListeUtilisateur = source.récupérerListeUtilisateurs()
        while (nouvelleListeUtilisateur == _ListeUtilisateur){
            nouvelleListeUtilisateur = source.récupérerListeUtilisateurs()
            break
        }
        _ListeUtilisateur = nouvelleListeUtilisateur as ArrayList<Utilisateur>
        return _ListeUtilisateur
    }
}