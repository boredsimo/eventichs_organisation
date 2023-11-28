package gti.g55.eventichs_organisation.Présentation.Présenteur

import android.app.DatePickerDialog
import android.os.Handler
import android.os.Message
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.ÉvènementException
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueCreation
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class PrésenteurCréation (private val _vue: VueCreation, private val _modèle: ModèleVueEvenement){

    private val handlerRéponse: Handler
    private var filEsclave: Thread? = null
    private val MSG_NOUVEL_EVENEMENT = 0
    private val MSG_ERREUR = 1
    private val MSG_ANNULER = 2

    fun ajouterÉvènement(code: Int, nom: String, dateDebut: String, dateFin: String, description: String, addresse: String, type: String) {

        filEsclave = Thread {
            var msg: Message? = null
            try {
                Thread.sleep(0)
                //temporaire
                _modèle.CreerEvenement(
                    Évènement(
                        code,
                        nom,
                        dateDebut,
                        dateFin,
                        description,
                        addresse,
                        type,
                        1
                    )
                )
            } catch (e: ÉvènementException) {
                msg = handlerRéponse.obtainMessage(MSG_ERREUR, e)
            } catch (e: InterruptedException) {
                msg = handlerRéponse.obtainMessage(MSG_ANNULER)
            }

            handlerRéponse.sendMessage(msg!!)
        }
        filEsclave!!.start()
    }

    init {
        handlerRéponse = object : Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                filEsclave = null
            }
        }
    }

}