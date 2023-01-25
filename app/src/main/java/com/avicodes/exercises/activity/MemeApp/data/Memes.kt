package com.avicodes.exercises.activity.MemeApp.data

import com.google.gson.annotations.SerializedName

data class Memes(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("success")
    val success: Boolean?
)