package gti.g55.eventichs_organisation.Présentation.Présenteur

import android.os.Handler
import android.os.Message
import android.util.Log
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleLogin
import gti.g55.eventichs_organisation.Présentation.Vue.VueLogin

class PrésentateurLogin (private val _vue: VueLogin, private val _modèle: ModèleLogin){

    private val handlerRéponse: Handler //idk if used
    private var filEsclave: Thread? = null
    private val MSG_NOUVELLE_LISTE = 0
    private val MSG_ERREUR = 1
    private val MSG_ANNULER = 2



    fun emailEtMotDePasseHandler(email: String, password: String){
        if(email.isNullOrBlank() && password.isNullOrBlank()){
            _vue.messageErreurVide()
            return
        }

        if(email.isNullOrBlank()){
            _vue.messageErreurVideMotDePasse()
            return
        }

        if(password.isNullOrBlank()){
            _vue.messageErreurVideEmail()
            return
        }
        if(_modèle.verifierEmailEtMotDePasse(email, password) != null){
            _vue.goToNextFragment()
        } else {
            _vue.messageErreurLogin()
        }
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