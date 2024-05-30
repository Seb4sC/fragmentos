package com.sena.fragmentos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.sena.fragmentos.PrimerFragment.Companion.ADDRESS_BUNDLE
import com.sena.fragmentos.PrimerFragment.Companion.NAME_BUNDLE
import com.sena.fragmentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = bundleOf(NAME_BUNDLE to "PruebaFragment", ADDRESS_BUNDLE to "Calle del Sena")

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PrimerFragment>(R.id.fragmentContainer, args = bundle)
        }

        binding.mainBtn.setOnClickListener{
            val secondFragment = SegundoFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, secondFragment).commit()
            }
        }
    }
}