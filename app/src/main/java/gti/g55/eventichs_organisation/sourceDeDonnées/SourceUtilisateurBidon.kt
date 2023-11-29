package gti.g55.eventichs_organisation.sourceDeDonnées

import gti.g55.eventichs_organisation.Domaine.Entités.Utilisateur
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceUtilisateur

class SourceUtilisateurBidon: SourceUtilisateur {
    var listeRetour: ArrayList<Utilisateur> = ArrayList()

    override fun récupérerListeUtilisateurs(): List<Utilisateur> {

        listeRetour.add(
            Utilisateur(
                0,
                "root",
                "root",
                "root@root.com",
                "root"
            )
        )
        listeRetour.add(
            Utilisateur(
                1,
                "Tremblay",
                "Andrew",
                "andrew.tremblay@gmail.ca",
                "crosemont"
            )
        )
        listeRetour.add(
            Utilisateur(
                2,
                "Gascon",
                "Alexandros",
                "alexandros.gascon@hotmail.ca",
                "crosemont"
            )
        )
        listeRetour.add(
            Utilisateur(
                3,
                "Fatene",
                "Mohamed",
                "mohamed.fatene@yahoo.ca",
                "crosemont"
            )
        )
        listeRetour.add(
            Utilisateur(
                4,
                "Ali",
                "Mahfuzur",
                "mahfuzur.ali@hotmail.com",
                "crosemont"
            )
        )
    return listeRetour
    }
}