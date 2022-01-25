package com.ukejee.lushandroidtaskapplication.data.api.launch.datasource

import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse

interface LaunchNetworkDataSource {

    suspend fun getAllLaunches(): List<GetLaunchResponse>
}