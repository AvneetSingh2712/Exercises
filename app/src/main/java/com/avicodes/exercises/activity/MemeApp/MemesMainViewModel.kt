package com.avicodes.exercises.activity.MemeApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avicodes.exercises.activity.MemeApp.data.API.MemesApi
import com.avicodes.exercises.activity.MemeApp.data.Memes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemesMainViewModel: ViewModel() {
    private val _response = MutableLiveData<Memes>()
    val response: LiveData<Memes>
        get() = _response

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _failed = MutableLiveData<String>()
    val failed: LiveData<String>
        get() = _failed

    init {
        _loading.value = true
        getApiResponse()
    }

    private fun getApiResponse() {
        MemesApi.apiService.getPhotos().enqueue(object : Callback<Memes> {
            override fun onResponse(call: Call<Memes>, response: Response<Memes>) {
                _response.value = response.body()
                _loading.value = false
            }

            override fun onFailure(call: Call<Memes>, t: Throwable) {
                _loading.value = false
                _failed.value = t.localizedMessage
            }
        })
    }
}