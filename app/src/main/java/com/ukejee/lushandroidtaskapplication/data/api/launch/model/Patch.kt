package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Patch(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("small")
    val small: String? = null
)