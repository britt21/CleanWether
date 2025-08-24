package com.mobile.wethercompose.di

import com.mobile.wethercompose.domain.WetherApi
import com.mobile.wethercompose.domain.WetherRepo
import com.mobile.wethercompose.domain.WetherRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WetherApi{
        return retrofit.create(WetherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(api: WetherApi): WetherRepo{
        return WetherRepoImpl(api)
    }
}