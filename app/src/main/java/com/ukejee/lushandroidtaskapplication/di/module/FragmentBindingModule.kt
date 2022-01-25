package com.ukejee.lushandroidtaskapplication.di.module

import com.ukejee.lushandroidtaskapplication.di.scope.FragmentScope
import com.ukejee.lushandroidtaskapplication.feature.launch.LaunchListFragment
import com.ukejee.lushandroidtaskapplication.feature.launch.LaunchListModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [LaunchListModule::class])
    internal abstract fun launchListFragmentInjector(): LaunchListFragment
}