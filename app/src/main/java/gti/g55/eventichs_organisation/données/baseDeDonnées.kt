package gti.g55.eventichs_organisation.données

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import gti.g55.eventichs_organisation.Présentation.Vue.Evenement
import gti.g55.eventichs_organisation.R
import java.text.SimpleDateFormat


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
        private const val COLUMN_photo = "Photo"
        // Table Preference
        private const val TABLE_preference = "Preference"
        private const val COLUMN_idPreference = "idPreference"
        private const val COLUMN_theme = "theme"
        private const val COLUMN_langue = "langue"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Table Evenement
        val CREATE_TABLE_Evenement = "CREATE TABLE $TABLE_evenement ($COLUMN_idEvenement INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_dateDebut Date, $COLUMN_dateFin Date, $COLUMN_type Text, $COLUMN_description Text, $COLUMN_photo Text);"
        db.execSQL(CREATE_TABLE_Evenement)
        // Table Preference
        val CREATE_TABLE_preference = "CREATE TABLE $TABLE_preference ($COLUMN_idPreference INTEGER PRIMARY KEY, $COLUMN_theme TEXT, $COLUMN_langue TEXT);"
        db.execSQL(CREATE_TABLE_preference)

        creerEvenement(db)
        // creerPreference(db)

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_evenement)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_preference)
        onCreate(db)
    }

    fun creerEvenement(db: SQLiteDatabase) {
        @SuppressLint("SimpleDateFormat")
        var dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val listeEvenements = mutableListOf(
            Evenement(),
            Evenement(),
            Evenement(),
            Evenement()
        )

        TODO("for (e in listeEvenements() {} ")
    }

    // Fonction qui flush la database pour éliminer les événements stockés localement
}