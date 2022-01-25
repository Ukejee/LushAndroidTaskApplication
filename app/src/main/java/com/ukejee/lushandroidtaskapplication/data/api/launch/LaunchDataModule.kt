package com.ukejee.lushandroidtaskapplication.data.api.launch

import com.ukejee.lushandroidtaskapplication.data.api.launch.datasource.LaunchNetworkDataSource
import com.ukejee.lushandroidtaskapplication.data.api.launch.datasource.LaunchRetrofitDataSource
import com.ukejee.lushandroidtaskapplication.data.api.launch.endpoint.LaunchEndpoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LaunchDataModule {

    //@AppScope
    @Provides
    fun provideLaunchEndpoint(retrofit: Retrofit):
            LaunchEndpoint = retrofit.create(LaunchEndpoint::class.java)

    //@AppScope
    @Provides
    fun provideLaunchNetworkDataSource(launchEndpoint: LaunchEndpoint):
            LaunchNetworkDataSource = LaunchRetrofitDataSource(launchEndpoint)

    //@AppScope
    @Provides
    fun provideAirtimeTransferProvider(
        launchNetworkDataSource: LaunchNetworkDataSource,
    ): LaunchRepositoryContract = LaunchRepository(
        launchNetworkDataSource
    )
}