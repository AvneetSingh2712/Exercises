package com.avicodes.exercises.activity.MemeApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.avicodes.exercises.R
import com.avicodes.exercises.databinding.ActivityMainBinding
import com.avicodes.exercises.databinding.ActivityMemeMainBinding

class MemeMainActivity : AppCompatActivity() {


    private var _binding: ActivityMemeMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MemesAdapter

    private val viewModel by lazy {
        ViewModelProvider(this)[MemesMainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMemeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MemesAdapter(MemesAdapter.OnClickListener { photo ->
            Toast.makeText(applicationContext, "${photo.name}", Toast.LENGTH_SHORT).show()
        })

        viewModel.response.observe(this, Observer { meme ->
            val list = meme.data?.memes
            adapter.submitList(list)
            binding.recyclerView.adapter = adapter
        })

        viewModel.loading.observe(this, Observer { loading ->
            binding.progressBar.isVisible = loading
        })

        viewModel.failed.observe(this, Observer { failed ->
            binding.textViewFailed.text = failed
            binding.textViewFailed.isVisible = true
        })
    }

}