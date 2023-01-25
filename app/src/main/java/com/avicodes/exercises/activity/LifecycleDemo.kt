package com.avicodes.exercises.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.avicodes.exercises.R
import com.avicodes.exercises.databinding.ActivityLifecycleDemoBinding

class LifecycleDemo : AppCompatActivity() {
    private var _binding: ActivityLifecycleDemoBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLifecycleDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState != null) {
            Log.i("Saved Data", savedInstanceState.getString(SAVED_VAL).toString())
        } else {
            Log.i("Saved Data", "No Data Saved")

        }

        Log.i("MY TAG", "onCreate Called...")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(SAVED_VAL, binding.etVal.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MY TAG", "onStart Called...")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MY TAG", "onResume Called...")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MY TAG", "onPause Called...")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MY TAG", "onStop Called...")
    }

    override fun onDestroy() {
        Log.i("MY TAG", "onDestroy Called...")
        super.onDestroy()
    }

    companion object {
        val SAVED_VAL = "SavedVal"
    }
}