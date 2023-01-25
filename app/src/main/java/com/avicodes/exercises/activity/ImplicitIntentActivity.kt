package com.avicodes.exercises.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avicodes.exercises.R
import com.avicodes.exercises.databinding.ActivityImplicitIntentBinding

class ImplicitIntentActivity : AppCompatActivity() {

    private var _binding : ActivityImplicitIntentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            btnCall.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:9690035006")
                startActivity(callIntent)
            }


            btnBrowse.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://appyhigh.com/"))
                startActivity(browserIntent)
            }

        }

    }
}