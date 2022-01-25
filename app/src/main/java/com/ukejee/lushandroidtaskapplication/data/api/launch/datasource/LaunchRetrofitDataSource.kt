package com.ukejee.lushandroidtaskapplication.data.api.launch.datasource

import com.ukejee.lushandroidtaskapplication.data.api.launch.endpoint.LaunchEndpoint
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse

class LaunchRetrofitDataSource(
    private val launchEndpoint: LaunchEndpoint
) : LaunchNetworkDataSource{

    override suspend fun getAllLaunches(): List<GetLaunchResponse> =
        launchEndpoint.getAllLaunches()
}