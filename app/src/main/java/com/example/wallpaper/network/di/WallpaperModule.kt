package com.example.wallpaper.network.di

import com.example.wallpaper.network.services.WallpaperService
import com.example.wallpaper.network.utils.UtilsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WallpaperModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(UtilsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesWallpaperApi(retrofit: Retrofit): WallpaperService {
        return retrofit.create(WallpaperService::class.java)
    }

}