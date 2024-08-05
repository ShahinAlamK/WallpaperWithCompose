package com.example.wallpaper.di

import com.example.wallpaper.data.remote.UnsplashApi
import com.example.wallpaper.common.UtilsApi
import com.example.wallpaper.data.repository.WallpaperRepoImpl
import com.example.wallpaper.domain.repository.WallpaperRepository
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
    fun providesWallpaperApi(retrofit: Retrofit): UnsplashApi {
        return retrofit.create(UnsplashApi::class.java)
    }

    @Provides
    @Singleton
    fun providesWallpaperRepository(wallpaperService: UnsplashApi): WallpaperRepository {
        return WallpaperRepoImpl(wallpaperService)
    }

}