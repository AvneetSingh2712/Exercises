package com.avicodes.exercises.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import com.avicodes.exercises.MainActivity
import com.avicodes.exercises.R
import com.avicodes.exercises.databinding.ActivityReceiveDataBinding

class ReceiveDataActivity : AppCompatActivity() {

    private var _binding : ActivityReceiveDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReceiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //get data from static
        var sharedFromDataShareActivity = DataShareActivity.dataShareActivityData
        Log.i("Got from Data Share Activity As static", sharedFromDataShareActivity)


        //through intent
        var intent1 = Intent()
        var name = intent1.getStringExtra(DataShareActivity.dataShareActivityData)
        Log.i("Got from Data Share Activity As intent", name.toString())

        binding.btnSendResult.setOnClickListener {
            intent1.putExtra("newString", "$name Processed")
            setResult(RESULT_OK, intent1)
            finish()
        }


        //through bundle
//        var intent2 = Intent()
//        var b: Bundle? = intent2.getBundleExtra(DataShareActivity.getBundle)
//        var data = b?.getString(DataShareActivity.dataShareActivityData)
//        Log.i("Got from Data Share Activity As intent with Bundle", data.toString())

    }
}