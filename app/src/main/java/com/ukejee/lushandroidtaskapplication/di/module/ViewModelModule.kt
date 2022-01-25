package com.ukejee.lushandroidtaskapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.ukejee.lushandroidtaskapplication.di.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory):
            ViewModelProvider.Factory
}