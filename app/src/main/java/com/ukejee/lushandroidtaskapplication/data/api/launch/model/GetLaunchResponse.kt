package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class GetLaunchResponse(
    @SerializedName("auto_update")
    val autoUpdate: Boolean? = null,
    @SerializedName("capsules")
    val capsules: List<Any>? = null,
    @SerializedName("cores")
    val cores: List<Core>? = null,
    @SerializedName("crew")
    val crew: List<Any>? = null,
    @SerializedName("date_local")
    val dateLocal: String? = null,
    @SerializedName("date_precision")
    val datePrecision: String? = null,
    @SerializedName("date_unix")
    val dateUnix: Int? = null,
    @SerializedName("date_utc")
    val dateUtc: String? = null,
    @SerializedName("details")
    val details: String? = null,
    @SerializedName("failures")
    val failures: List<Any>? = null,
    @SerializedName("fairings")
    val fairings: Fairings? = null,
    @SerializedName("flight_number")
    val flightNumber: Int? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("launch_library_id")
    val launchLibraryId: String? = null,
    @SerializedName("launchpad")
    val launchpad: String? = null,
    @SerializedName("links")
    val links: Links? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("net")
    val net: Boolean? = null,
    @SerializedName("payloads")
    val payloads: List<String>? = null,
    @SerializedName("rocket")
    val rocket: String? = null,
    @SerializedName("ships")
    val ships: List<Any>? = null,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Int? = null,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String? = null,
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("tbd")
    val tbd: Boolean? = null,
    @SerializedName("upcoming")
    val upcoming: Boolean? = null,
    @SerializedName("window")
    val window: Int? = null
)