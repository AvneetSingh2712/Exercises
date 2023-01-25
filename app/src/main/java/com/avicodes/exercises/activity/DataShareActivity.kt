package com.avicodes.exercises.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.avicodes.exercises.MainActivity
import com.avicodes.exercises.R
import com.avicodes.exercises.databinding.ActivityDataShareBinding
import com.avicodes.exercises.databinding.ActivityMainBinding

class DataShareActivity : AppCompatActivity() {

    //static for data sharing
    companion object {
        var dataShareActivityData: String = "In Data Share Activity"
        var getBundle: String = "Get Bundle"
    }


    private var _binding: ActivityDataShareBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDataShareBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var editActivityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                if (data != null) {
                    val editedString = data.extras!!.getString("newString")
                    Log.i("MYTAG","Data Got back from second activity $editedString" )
                }
            }

        }

        binding.apply {
            btnShareDirect.setOnClickListener {
                val intent = Intent(this@DataShareActivity, ReceiveDataActivity::class.java)
                intent.putExtra(dataShareActivityData, "Data Share Activity Without Bundle")
                editActivityResultLauncher.launch(intent)
            }


            btnShareBundle.setOnClickListener {
                val intent = Intent(this@DataShareActivity, ReceiveDataActivity::class.java)
                var b : Bundle = Bundle()
                b.putString(dataShareActivityData, "Data Share Activity With Bundle")
                intent.putExtra(getBundle, b)
                startActivity(intent)
            }



        }


    }
}