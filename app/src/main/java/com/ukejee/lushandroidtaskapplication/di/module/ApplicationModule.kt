package com.ukejee.lushandroidtaskapplication.di.module

import android.content.Context
import com.ukejee.lushandroidtaskapplication.application.FalconApplication
import com.ukejee.lushandroidtaskapplication.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {


    @AppScope
    @Provides
    fun bindContext(application: FalconApplication): Context = application

}
