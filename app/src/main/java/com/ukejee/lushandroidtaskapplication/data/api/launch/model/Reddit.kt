package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Reddit(
    @SerializedName("campaign")
    val campaign: Any? = null,
    @SerializedName("launch")
    val launch: Any? = null,
    @SerializedName("media")
    val media: Any? = null,
    @SerializedName("recovery")
    val recovery: String? = null
)