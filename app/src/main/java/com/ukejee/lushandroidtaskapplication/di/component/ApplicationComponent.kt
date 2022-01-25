package com.ukejee.lushandroidtaskapplication.di.component

import com.ukejee.lushandroidtaskapplication.application.FalconApplication
import com.ukejee.lushandroidtaskapplication.data.api.ApiModule
import com.ukejee.lushandroidtaskapplication.di.module.ApplicationModule
import com.ukejee.lushandroidtaskapplication.di.module.FragmentBindingModule
import com.ukejee.lushandroidtaskapplication.di.module.ViewModelModule
import com.ukejee.lushandroidtaskapplication.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        FragmentBindingModule::class,
        ApplicationModule::class,
        ApiModule::class
    ]
)
internal interface ApplicationComponent : AndroidInjector<FalconApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FalconApplication>()
}