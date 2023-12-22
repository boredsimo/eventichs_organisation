package gti.g55.eventichs_organisation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import java.util.prefs.AbstractPreferences

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
    private lateinit var switch: Switch
    private lateinit var sharedPreferences: SharedPreferences
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
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switch = view.findViewById(R.id.switch1)
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val savedThemeMode = sharedPreferences.getInt("theme_mode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        AppCompatDelegate.setDefaultNightMode(savedThemeMode)

        switch.isChecked = (savedThemeMode == AppCompatDelegate.MODE_NIGHT_YES)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                saveThemeMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                saveThemeMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
    private fun saveThemeMode(themeMode: Int) {
        with(sharedPreferences.edit()) {
            putInt("theme_mode", themeMode)
            apply()
        }
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

}