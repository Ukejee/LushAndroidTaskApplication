package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("core")
    val core: Any? = null,
    @SerializedName("flight")
    val flight: Any? = null,
    @SerializedName("gridfins")
    val gridfins: Any? = null,
    @SerializedName("landing_attempt")
    val landingAttempt: Any? = null,
    @SerializedName("landing_success")
    val landingSuccess: Any? = null,
    @SerializedName("landing_type")
    val landingType: Any? = null,
    @SerializedName("landpad")
    val landpad: Any? = null,
    @SerializedName("legs")
    val legs: Any? = null,
    @SerializedName("reused")
    val reused: Any? = null
)