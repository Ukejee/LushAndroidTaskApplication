package com.ukejee.lushandroidtaskapplication.data.api.launch.model


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article")
    val article: Any? = null,
    @SerializedName("flickr")
    val flickr: Flickr? = null,
    @SerializedName("patch")
    val patch: Patch? = null,
    @SerializedName("presskit")
    val presskit: Any? = null,
    @SerializedName("reddit")
    val reddit: Reddit? = null,
    @SerializedName("webcast")
    val webcast: Any? = null,
    @SerializedName("wikipedia")
    val wikipedia: Any? = null,
    @SerializedName("youtube_id")
    val youtubeId: Any? = null
)