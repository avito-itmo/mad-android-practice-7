package com.kostyarazboynik.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.parcelize.Parcelize

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {

    private var args: SettingsFragmentArguments? = null
    private var defaultIntArgument: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            args = getParcelable(ARG_SETTINGS)
            defaultIntArgument = getInt(OTHER_DEFAULT_INT_ARGUMENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    companion object {
        private const val ARG_SETTINGS = "settings_args_key"
        private const val OTHER_DEFAULT_INT_ARGUMENT = "other_arg_key"

        fun createArgs(args: SettingsFragmentArguments) = Bundle().apply {
            putParcelable(ARG_SETTINGS, args)
            putInt(OTHER_DEFAULT_INT_ARGUMENT, 0)
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param args [SettingsFragmentArguments] containing fragment parameters.
         * @return A new instance of fragment SettingsFragment.
         */
        fun newInstance(args: SettingsFragmentArguments) = SettingsFragment().apply {
            arguments = createArgs(args)
        }
    }
}

@Parcelize
data class SettingsFragmentArguments(
    val argument1: String,
    val argument2: Int,
) : Parcelable
