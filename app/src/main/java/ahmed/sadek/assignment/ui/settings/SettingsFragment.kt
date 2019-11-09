package ahmed.sadek.assignment.ui.settings

import ahmed.sadek.assignment.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.databinding.FragmentSettingsBinding
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lightOption.setOnClickListener{Mode(requireActivity()).setLight()}
        binding.darkOption.setOnClickListener{Mode(requireActivity()).setDark() }

    }
}