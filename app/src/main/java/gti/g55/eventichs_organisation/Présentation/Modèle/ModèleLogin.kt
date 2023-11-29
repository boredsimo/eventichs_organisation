package gti.g55.eventichs_organisation.Présentation.Modèle

import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Utilisateur
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionUtilisateur
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceUtilisateur

class ModèleLogin (val source: SourceUtilisateur) {

    fun verifierEmailEtMotDePasse(email: String, password: String): Utilisateur? {
        var listeUtilisateurs = InteracteurAcquisitionUtilisateur(source).obtenirNouvelleListeUtilisateur()
        for (unUtilisateur in listeUtilisateurs){
            if (unUtilisateur.courriel == email && unUtilisateur.motDePasse == password){
                return unUtilisateur
            }
        }
        return null
    }
}