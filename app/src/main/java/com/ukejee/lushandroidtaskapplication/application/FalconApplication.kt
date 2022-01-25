package com.ukejee.lushandroidtaskapplication.application

import com.ukejee.lushandroidtaskapplication.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FalconApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<FalconApplication> =
        DaggerApplicationComponent.builder().create(this)

}