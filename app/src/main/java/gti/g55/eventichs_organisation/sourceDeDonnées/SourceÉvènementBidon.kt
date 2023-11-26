package gti.g55.eventichs_organisation.sourceDeDonnées

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import kotlin.random.Random
import kotlin.random.nextInt

class SourceÉvènementBidon : SourceÉvènement {

    var listeÉvènement = générerListeÉvènements()

    override fun récupérerListeÉvènements(): List<Évènement> {
        return listeÉvènement
    }

    override fun ajouterÉvènement(evenement: Évènement){
        listeÉvènement.add(evenement)
    }



    fun générerListeÉvènements(): MutableList<Évènement> {
        var listeRetour: ArrayList<Évènement> = ArrayList()

        while(listeRetour.size <= 10) {
            when (Random.nextInt(4)) {
                0 -> listeRetour.add(
                    Évènement(
                        1,
                        "Grève Générale Illimitée",
                        "21 Novembre 2023 à 08:00",
                        "23 Novembre 2023 à 08:00",
                        "Venez dénoncer la corruption du gouvernement qui choisit d'investir dans des choses inutiles en place de donner de l'argent aux professeurs!!!1!!",
                        "1235 Rue de la Montagne, Montréal, QC, H3G 1Z1, Canada",
                        "Public",
                        1
                    )
                )

                1 -> listeRetour.add(
                    Évènement(
                        2,
                        "Group de danse sensuelle dans la pluie",
                        "24 Novembre 2023 à 08:00",
                        "24 Novembre 2023 à 14:00",
                        "Je veux sentir jeune, pourquoi doit-on vieillir :(",
                        "360 Rue Saint-Antoine O, Montréal, QC, H2Y 3X4, Canada",
                        "Public",
                        1
                    )
                )

                2 -> listeRetour.add(
                    Évènement(
                        3,
                        "LIBÉRATION INCONDITIONNELLE DE LA PALESTINE",
                        "15 NOVEMBRE 2023",
                        "15 NOVEMBRE 2023",
                        "FROM THE RIVER TO THE SEA, PALESTINE WILL BE FREE",
                        "7895 Boulevard Décarie, Montréal, QC, H4P 2H2, Canada",
                        "Public",
                        1
                    )
                )

                3 -> listeRetour.add(
                    Évènement(
                        4,
                        "Pizza time avec Alexandros",
                        "01-01-2023",
                        "08-08-3024",
                        "Piza",
                        "2000 Avenue McGill College, Montréal, QC, H3A 3H3, Canada",
                        "Privée",
                        1
                    )
                )

                4 -> listeRetour.add(
                    Évènement(
                        5,
                        "Meatman's meat",
                        "20 Février 2024",
                        "21 Février 2024",
                        "Savourer la viande de Meatman, des mains propres du Meatman lui-même!!",
                        "55 Avenue du Mont-Royal O, Montréal, QC, H2T 2S6, Canada",
                        "Public",
                        1
                    )
                )

            }
        }



        return listeRetour

    }

}