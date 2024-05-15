package com.example.wallpaper.network.services

import com.example.wallpaper.network.models.WallpaperModel
import com.example.wallpaper.network.utils.UtilsApi
import retrofit2.http.GET
import retrofit2.http.Url

interface WallpaperService {
    @GET
    suspend fun fetchWallpaper(@Url endpoint: String): WallpaperModel

}