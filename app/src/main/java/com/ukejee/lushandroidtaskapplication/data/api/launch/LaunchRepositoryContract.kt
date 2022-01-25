package com.ukejee.lushandroidtaskapplication.data.api.launch

import com.ukejee.lushandroidtaskapplication.data.api.Resource
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse

interface LaunchRepositoryContract {

    suspend fun fetchAllLaunches(): Resource<List<GetLaunchResponse>?>
}