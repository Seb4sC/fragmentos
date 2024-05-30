package com.sena.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sena.fragmentos.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {
    private var name: String? = null
    private var address: String? = null
    private lateinit var binding: FragmentSegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(PrimerFragment.NAME_BUNDLE)
            address = it.getString(PrimerFragment.ADDRESS_BUNDLE)
            Log.i("prueba", name.orEmpty())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        const val NAME_BUNDLE = "name_bundle"
        const val ADDRESS_BUNDLE = "address_bundle"

        @JvmStatic
        fun newInstance(name: String, address: String) = PrimerFragment().apply {
            arguments = Bundle().apply {
                putString(NAME_BUNDLE, name)
                putString(ADDRESS_BUNDLE, address)
            }
        }
    }
}