package gti.g55.eventichs_organisation.sourceDeDonnées

import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import kotlin.random.Random
import kotlin.random.nextInt

class SourceÉvènementBidon : SourceÉvènement {

    override fun récupérerListeÉvènements(): List<Évènement> {
        var listeRetour: ArrayList<Évènement> = ArrayList()


                 listeRetour.add(
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

                listeRetour.add(
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

                listeRetour.add(
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

                listeRetour.add(
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

                listeRetour.add(
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
                listeRetour.add(
                    Évènement(
                        6,
                        "Brunch avec des soldats qui ont du PTSD",
                        "9 Mai 2024",
                        "9 Mai 2024",
                        "Écoutez aux histoires traumatisantes et perturbantes de nos vétérans, tout en réjouissant à des bons petits sandwichs!",
                        "1 Notre-Dame St W, Montreal, Quebec H2Y 1S5, Canada",
                        "Public",
                        1
                    )
                )
                listeRetour.add(
                    Évènement(
                        7,
                        "Le pistolet de massage de Wissem",
                        "20 Décembre 2023",
                        "31 Décembre 2023",
                        "Veuillez venir visionner le chef-d'oeuvre du grand réalisateur Wissem au Cinéma Cineplex Odeon Quartier Latin!!!",
                        "350 Rue Émery, Montréal, QC H2X 1J1m, Canada",
                        "Public",
                        1
                    )
                )
                listeRetour.add(
                    Évènement(
                        8,
                        "Joe's Bangers & Mash Grand Opening",
                        "30 Mars 1922",
                        "31 Mars 1922",
                        "C'est la grande ouverture de 'Joe's Bangers & Mash!' Essayez les saucisses de Joe! Les hot-dogs de Joe! La viande de Joe! Pour tout le monde!",
                        "6400 16e Avenue, Montréal, QC H1X 2S9, Canada",
                        "Public",
                        1
                    )
                )
                listeRetour.add(
                    Évènement(
                        9,
                        "SCRUM vs CRUD: Revenge of the Agiles",
                        "31 Novembre 3021, 9:75am",
                        "34 Novembre 3021: 11:00am",
                        "Dans la cité numérique de Technopolis, SCRUM et CRUD se livrent une lutte acharnée. L'émergence d'Agile Fusion, mélangeant leurs forces, bouleverse tout. Cette alliance inattendue conduit à une révolution technologique, prouvant que l'union et l'innovation sont plus puissantes que la rivalité. Triomphe de l'agilité partagée.",
                        "49.120262, -32.343221",
                        "Public",
                        1
                    )
                )
        return listeRetour
    }
}