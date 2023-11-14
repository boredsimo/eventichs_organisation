package gti.g55.eventichs_organisation.Présentation.Présenteur

import android.os.Handler
import android.os.Message
import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.ÉvènementException
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement

class PrésenteurEvenement (private val _vue: VueEvenement, private val _modèle: ModèleVueEvenement){

    private val handlerRéponse: Handler //idk if used
    private var filEsclave: Thread? = null
    private val MSG_NOUVELLE_LISTE = 0
    private val MSG_ERREUR = 1
    private val MSG_ANNULER = 2

    //Tiré de progcité
    //TODO: REMOVE THESE COMMENTS BEFORE PRESENTATION

    //Error-catching api interaction function. afaik the error checking is redundant (FOR NOW)
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

    fun searchList(newText: String){
        val dataSearchÉvènement = mutableListOf<Évènement>()

        for (évènement in _modèle.ListeÉvènementCourante) {
            if (évènement.nom.lowercase().contains(newText.lowercase())) {
                dataSearchÉvènement.add(évènement)
            }

        }

        _vue.afficherRecyclerView(dataSearchÉvènement)
    }

    init {
        handlerRéponse = object : Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                filEsclave = null
                if(msg.what == MSG_NOUVELLE_LISTE){
                    _vue.afficherRecyclerView(_modèle.RemplacerListeÉvènements())
                } else if (msg.what == MSG_ERREUR) {
                    Log.e("progcite", "Erreur d'accès à l'api", msg.obj as Throwable)
                }
            }
        }
    }


}