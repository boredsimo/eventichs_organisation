package gti.g55.eventichs_organisation.données

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.preference.Preference
import gti.g55.eventichs_organisation.Domaine.Entités.Préférence
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionÉvènement
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date


class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION ) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "EventichsDB"
        // Table Evenement
        private const val TABLE_evenement = "Evenement"
        private const val COLUMN_idEvenement = "idEvenement"
        private const val COLUMN_nomEvenement = "nomEvenement"
        private const val COLUMN_dateDebut = "dateDebut"
        private const val COLUMN_dateFin = "dateFin"
        private const val COLUMN_type = "Type"
        private const val COLUMN_description = "Description"
        private const val COLUMN_IdOrganisation = "idOrganisation"
        // private const val COLUMN_photo = "Photo"

        // Table Preference
        private const val TABLE_preference = "Preference"
        private const val COLUMN_idPreference = "idPreference"
        private const val COLUMN_theme = "theme"
        private const val COLUMN_langue = "langue"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Table Evenement
        val CREATE_TABLE_Evenement = "CREATE TABLE $TABLE_evenement ($COLUMN_idEvenement INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_nomEvenement TEXT, $COLUMN_dateDebut Date, $COLUMN_dateFin Date, $COLUMN_type TEXT, $COLUMN_description TEXT, $COLUMN_IdOrganisation Integer);"
        db.execSQL(CREATE_TABLE_Evenement)
        // Table Preference
        val CREATE_TABLE_preference = "CREATE TABLE $TABLE_preference ($COLUMN_idPreference INTEGER PRIMARY KEY, $COLUMN_theme TEXT, $COLUMN_langue TEXT);"
        db.execSQL(CREATE_TABLE_preference)
        creerEvenement(db)
        creerPreference(db)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_evenement)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_preference)
        onCreate(db)
    }

    // Création d'événements
    fun creerEvenement(db: SQLiteDatabase) {
        @SuppressLint("SimpleDateFormat")
        var dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val listeEvenements = InteracteurAcquisitionÉvènement(SourceÉvènementBidon).obtenirNouvelleListeÉvènement()
        val INSERT_TABLE_Evenement = "INSERT INTO $TABLE_evenement ($COLUMN_nomEvenement, $COLUMN_dateDebut, $COLUMN_dateFin, $COLUMN_type, $COLUMN_description, $COLUMN_IdOrganisation)" +
                "VALUES (e.nom, e.dateDebut, e.dateFin, e.description, e.type, e.organisation_id)"

        for (e in listeEvenements){
            val valeur = ContentValues()
            valeur.put(COLUMN_nomEvenement, e.nom)
            valeur.put(COLUMN_dateDebut, e.dateDebut)
            valeur.put(COLUMN_dateFin, e.dateFin)
            valeur.put(COLUMN_description, e.description)
            valeur.put(COLUMN_type, e.type)
            valeur.put(COLUMN_IdOrganisation, e.organisation_id)
            db.execSQL(INSERT_TABLE_Evenement)
        }
    }

    // Ajout d'événements
    fun ajouterEvenement(h: Évènement) {
        val valeur = ContentValues()
        valeur.put(COLUMN_nomEvenement, h.nom)
        valeur.put(COLUMN_dateDebut, h.dateDebut)
        valeur.put(COLUMN_dateFin, h.dateFin)
        valeur.put(COLUMN_description, h.description)
        valeur.put(COLUMN_type, h.type)
        valeur.put(COLUMN_IdOrganisation, h.organisation_id)
        val db = writableDatabase
        db.insert(TABLE_evenement, null, valeur)
        db.close()
    }

    // Modification des événements
    fun modifierEvenement(idEvenement: Int, nomEvenement: String, dateDebut: LocalDate, dateFin: LocalDate, typeEvenement: String, descriptionEvenement: String, idOrganisation: Int ) {
        val db = writableDatabase
        db.execSQL("UPDATE $TABLE_evenement SET "+
                "$COLUMN_idEvenement = '$idEvenement' WHERE $COLUMN_idEvenement = $idEvenement, "+
                "$COLUMN_nomEvenement = '$nomEvenement' WHERE $COLUMN_nomEvenement = $nomEvenement, "+
                "$COLUMN_dateDebut = '$dateDebut' WHERE $COLUMN_dateDebut = $dateDebut, "+
                "$COLUMN_dateFin = '$dateFin' WHERE $COLUMN_dateFin = $dateFin, "+
                "$COLUMN_type = '$typeEvenement' WHERE $COLUMN_type = $typeEvenement, "+
                "$COLUMN_description = '$descriptionEvenement' WHERE $COLUMN_description = $descriptionEvenement, "+
                "$COLUMN_IdOrganisation = '$idOrganisation' WHERE $COLUMN_IdOrganisation = $idOrganisation"
        )
        db.close()
    }

    // Suppression des événements
    fun supprimerEvenement(idEvenement: Int) {
        val db = writableDatabase
        db.execSQL(
            "DELETE FROM "+ TABLE_evenement + " WHERE " + COLUMN_idEvenement + "= \"" + idEvenement + "\";"
        )
    }

    // Création des préférences
    fun creerPreference(db: SQLiteDatabase) {
        val préférences = Préférence("Français", "Light")
        val valeur = ContentValues()
        valeur.put(COLUMN_langue, préférences.langue)
        valeur.put(COLUMN_theme, préférences.thème)
        db.insert(TABLE_preference, null, valeur)
    }

    // Ajout de préférences
    fun ajouterPreference(h: Préférence) {
        val valeur = ContentValues()
        valeur.put(COLUMN_langue, h.langue)
        valeur.put(COLUMN_theme, h.thème)
        val db = writableDatabase
        db.insert(TABLE_preference, null, valeur)
        db.close()
    }

    // Recherche des préférences
    fun rechercherPref(): Préférence {
        lateinit var preference: Préférence
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_preference LIMIT 1", null)
        if (!cursor.moveToFirst())
            preference = Préférence("Français", "Light")
        else {
            val langueIndex = cursor.getColumnIndex(COLUMN_langue)
            val themeIndex = cursor.getColumnIndex(COLUMN_theme)
            val langue = cursor.getString(langueIndex)
            val theme = cursor.getString(themeIndex)
            preference = Préférence(langue,theme)
        }
        cursor.close()
        db.close()
        return preference
    }

    // Fonction qui flush la database pour éliminer les événements stockés localement
}