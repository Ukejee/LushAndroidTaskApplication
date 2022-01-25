package com.ukejee.lushandroidtaskapplication.feature.launch

import androidx.lifecycle.ViewModel
import com.ukejee.lushandroidtaskapplication.data.api.launch.LaunchRepositoryContract
import com.ukejee.lushandroidtaskapplication.di.viewModel.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class LaunchListModule {

    @Provides
    @IntoMap
    @ViewModelKey(LaunchListViewModel::class)
    fun provideLaunchListViewModel(
        repositoryContract: LaunchRepositoryContract
    ): ViewModel = LaunchListViewModel(repositoryContract)
}

