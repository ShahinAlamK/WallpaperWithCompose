package com.example.wallpaper.network.utils

import com.example.wallpaper.network.viewmodels.WallpaperState

sealed class WallpaperStatus {
    data class Success(val data: WallpaperState) : WallpaperStatus()
    data class Error(var error: String) : WallpaperStatus()
    data object Loading : WallpaperStatus()
    data object Empty : WallpaperStatus()

}