package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Flickr(
    @SerializedName("original")
    val original: List<Any>? = null,
    @SerializedName("small")
    val small: List<Any>? = null
)