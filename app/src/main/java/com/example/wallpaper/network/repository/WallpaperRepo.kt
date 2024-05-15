package com.example.wallpaper.network.repository

import com.example.wallpaper.network.models.WallpaperModel
import com.example.wallpaper.network.services.WallpaperService
import javax.inject.Inject

class WallpaperRepo @Inject constructor(private val wallpaperService: WallpaperService) {

    suspend fun getWallpaper(endPoints: String): WallpaperModel {
        return wallpaperService.fetchWallpaper(endPoints)
    }


}