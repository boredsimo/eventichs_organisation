package gti.g55.eventichs_organisation.Présentation.Vue

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleLogin
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésentateurLogin
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceUtilisateurBidon
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_log_in.newInstance] factory method to
 * create an instance of this fragment.
 */
class VueLogin : Fragment() {

    private var _présenteur: PrésentateurLogin? = null

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnLogin: Button
    lateinit var txtError: TextView


    fun setPrésenteur(présentateurLogin: PrésentateurLogin){
        _présenteur = présentateurLogin
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = view.findViewById(R.id.editEmail)
        password = view.findViewById(R.id.editPassword)
        btnLogin = view.findViewById(R.id.btnLogin)
        txtError = view.findViewById(R.id.textErrorLogin)

        btnLogin.setOnClickListener {
            _présenteur?.emailEtMotDePasseHandler(email.text.toString(), password.text.toString())

        }

        val modèle = ModèleLogin(SourceUtilisateurBidon())
        _présenteur = PrésentateurLogin(this, modèle)
        
        setPrésenteur(_présenteur!!)
    }


    fun goToNextFragment(){
        view?.let { Navigation.findNavController(it).navigate(R.id.action_vueLogin_to_evenement) }
    }

    fun messageErreur(){
        txtError.text = "ERROR"
    }

}