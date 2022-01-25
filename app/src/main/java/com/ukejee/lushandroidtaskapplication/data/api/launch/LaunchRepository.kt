package com.ukejee.lushandroidtaskapplication.data.api.launch

import com.ukejee.lushandroidtaskapplication.data.api.Resource
import com.ukejee.lushandroidtaskapplication.data.api.launch.datasource.LaunchNetworkDataSource
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LaunchRepository(private val networkDataSource: LaunchNetworkDataSource) :
    LaunchRepositoryContract {

    override suspend fun fetchAllLaunches(): Resource<List<GetLaunchResponse>?> {
        return withContext(Dispatchers.IO) {
            try {
              Resource.success(data = networkDataSource.getAllLaunches())
            } catch (throwable: Throwable) {
                Resource.error(data = null, message = throwable.message ?: "Error Occurred!")
            }
        }

    }
}