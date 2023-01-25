package com.avicodes.exercises.activity.MemeApp.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("memes")
    val memes: List<Meme?>?
)
