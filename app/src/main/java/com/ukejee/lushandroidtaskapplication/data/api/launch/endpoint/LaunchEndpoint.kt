package com.ukejee.lushandroidtaskapplication.data.api.launch.endpoint

import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse
import retrofit2.http.GET

interface LaunchEndpoint {

    @GET("launches")
    suspend fun getAllLaunches(): List<GetLaunchResponse>
}