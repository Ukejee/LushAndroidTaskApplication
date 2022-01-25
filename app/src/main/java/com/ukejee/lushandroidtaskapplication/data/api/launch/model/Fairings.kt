package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("recovered")
    val recovered: Any? = null,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Any? = null,
    @SerializedName("reused")
    val reused: Any? = null,
    @SerializedName("ships")
    val ships: List<Any>? = null
)