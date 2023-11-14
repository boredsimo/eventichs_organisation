package gti.g55.eventichs_organisation.ui.activité

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import gti.g55.eventichs_organisation.Présentation.Vue.VueEvenement
import gti.g55.eventichs_organisation.R
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

class MainActivity : AppCompatActivity() {
    private var _présenteur: PrésenteurEvenement? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val modèle = ModèleVueEvenement(SourceÉvènementBidon())
        val vue = VueEvenement()
        _présenteur = PrésenteurEvenement(vue, modèle)

        vue.setPrésenteur(_présenteur)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.nav_host_fragment, vue)
        ft.commit()


    }

    public override fun onStart() {
        super.onStart()
        _présenteur!!.rafraichirListeÉvènements()

    }
}