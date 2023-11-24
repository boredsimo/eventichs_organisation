package gti.g55.eventichs_organisation.Présentation.Présenteur

import android.os.Handler
import android.os.Message
import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Interacteurs.ÉvènementException
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueModifierEvenement

class PrésentateurModifierEvenement(private val _vue: VueModifierEvenement, private val _modèle: ModèleVueEvenement) {

    private val handlerRéponse: Handler //idk if used
    private var filEsclave: Thread? = null
    private val MSG_NOUVELLE_LISTE = 0
    private val MSG_ERREUR = 1
    private val MSG_ANNULER = 2

    fun rafraichirListeÉvènements(){
        //new thread
        filEsclave = Thread {
            //kinda like an api status message
            var msg: Message? = null
            try {
                Thread.sleep(0)
                //THIS IS THE ACTUAL MVP INTERACTION, HERE, RIGHT HERE, BELOW
                val nouvelleListeEvenement = _modèle.RemplacerListeÉvènements()
                //If it worked, and it should, msg = 0 (success)
                msg = handlerRéponse.obtainMessage(MSG_NOUVELLE_LISTE, nouvelleListeEvenement)

                //if not,
            } catch (e: ÉvènementException) {
                msg = handlerRéponse.obtainMessage(MSG_ERREUR, e)
            } catch (e: InterruptedException) {
                msg = handlerRéponse.obtainMessage(MSG_ANNULER)
            }
            //afterwards, send message
            handlerRéponse.sendMessage(msg!!)
        }
        filEsclave!!.start()
    }

    //No idea, Lafrance implemented it, so i did tooooo
    fun annulerListeSuivante() {
        if (filEsclave != null) {
            filEsclave!!.interrupt()
        }
    }

    fun saveEvenement(codeEvenement: Int?, nomEvenement: String, dateDébut: String, dateFin: String, adresse: String){
        val unEvenement = codeEvenement?.let { _modèle.findEvenementByID(it) }
        unEvenement?.nom?.let { Log.e("LOG", it) }
    }




    init {
        handlerRéponse = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                filEsclave = null
                if (msg.what == MSG_NOUVELLE_LISTE) {
                    //_vue.afficherRecyclerView(_modèle.RemplacerListeÉvènements())
                } else if (msg.what == MSG_ERREUR) {
                    Log.e("progcite", "Erreur d'accès à l'api", msg.obj as Throwable)
                }
            }
        }
    }
}