package gti.g55.eventichs_organisation

import AppBD
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var switchTheme: Switch
    private lateinit var switchLangue: Switch

    lateinit var buttonSave: Button
    lateinit var bd: AppBD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchLangue = view.findViewById(R.id.switch2)
        switchTheme = view.findViewById(R.id.switch1)
        buttonSave = view.findViewById(R.id.RetournerMenu)

        bd = AppBD(requireContext())

        if (bd.getThemeById(1)?.toInt() == 2){
                switchTheme.isChecked = true
            }
        if (bd.getLangueParID(1) == "EN"){
                switchLangue.isChecked = true
            }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                saveThemeMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                saveThemeMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        switchLangue.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                sauvegarderLocale("FR")
            } else {
                sauvegarderLocale("EN")
            }
        }

        buttonSave.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_evenement)
        }
    }
    private fun saveThemeMode(themeMode: Int) {

        AppCompatDelegate.setDefaultNightMode(themeMode)
        bd.changerThemeParID(1, themeMode.toString())

    }

    private fun sauvegarderLocale(locale: String) {

        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(locale))
        bd.changerLangueParID(1, locale)

    }

}