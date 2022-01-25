package com.ukejee.lushandroidtaskapplication.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ukejee.lushandroidtaskapplication.data.api.launch.LaunchDataModule
import com.ukejee.lushandroidtaskapplication.di.scope.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(
    includes = [
        LaunchDataModule::class
    ]
)
class ApiModule {

    @AppScope
    @Provides
    fun provideRetrofit(converterFactory: Converter.Factory,client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiConstants.BASE_ENDPOINT)
            .client(client)
            .build()
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(false)
            .readTimeout(ApiConstants.DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(ApiConstants.DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()
    }

    @AppScope
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @AppScope
    @Provides
    fun providesConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }
}