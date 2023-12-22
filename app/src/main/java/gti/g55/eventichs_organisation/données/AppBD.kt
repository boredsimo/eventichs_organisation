import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Gabarit par ChatGPT, implémenté par un humain.
class AppBD(context: Context) : SQLiteOpenHelper(context, NOM_BD, null, DB_VERSION) {

    companion object {
        private const val NOM_BD = "reglages.db"
        private const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE langue ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "langue TEXT)")

        db.execSQL("CREATE TABLE thème ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "thème TEXT)")

        db.execSQL("INSERT INTO thème VALUES(1,'2')")
        db.execSQL("INSERT INTO langue VALUES(1,'FR')")
    }

    override fun onUpgrade(db: SQLiteDatabase, vieilleVersion: Int, nouvelleVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS langue")
        db.execSQL("DROP TABLE IF EXISTS thème")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getLangueParID(langueID: Int): String? {
        val db = readableDatabase
        val cursor = db.query(
            "langue",
            arrayOf("langue"),
            "_id=?",
            arrayOf(langueID.toString()),
            null,
            null,
            null
        )
        var language: String? = null
        if (cursor.moveToFirst()) {
            language = cursor.getString(cursor.getColumnIndex("langue"))
        }
        cursor.close()
        return language
    }

    fun changerLangueParID(langueID: Int, newLangue: String): Int {
        val db = writableDatabase
        val values = ContentValues()
        values.put("langue", newLangue)
        return db.update(
            "langue",
            values,
            "_id=?",
            arrayOf(langueID.toString())
        )
    }

    @SuppressLint("Range")
    fun getThemeById (themeID: Int): String? {
        val db = readableDatabase
        val cursor = db.query(
            "thème",
            arrayOf("thème"),
            "_id=?",
            arrayOf(themeID.toString()),
            null,
            null,
            null
        )
        var thème: String? = null
        if (cursor.moveToFirst()) {
            thème = cursor.getString(cursor.getColumnIndex("thème"))
        }
        cursor.close()
        return thème
    }

    fun changerThemeParID(themeID: Int, newTheme: String): Int {
        val db = writableDatabase
        val values = ContentValues()
        values.put("thème", newTheme)
        return db.update(
            "thème",
            values,
            "_id=?",
            arrayOf(themeID.toString())
        )
    }


}

