package com.example.wallpaper.network.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.components.list
import com.example.wallpaper.network.models.WallpaperModel
import com.example.wallpaper.network.repository.WallpaperRepo
import com.example.wallpaper.network.services.WallpaperService
import com.example.wallpaper.network.utils.UtilsApi.API_KEY
import com.example.wallpaper.network.utils.WallpaperStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(private val wallpaperRepo: WallpaperRepo) :
    ViewModel() {
    private var category = list[0]

    var isCategorySelected by mutableStateOf(0)
    fun updateCategory(newCategory: String) {
        category = newCategory
        fetchWallpaper()
    }

    var wallpaperStatus by mutableStateOf<WallpaperStatus>(WallpaperStatus.Loading)

    var detailsImage by mutableStateOf<String>("")

    fun updateDetailsImage(newDetailsImage: String) {
        detailsImage = newDetailsImage
    }

    fun fetchWallpaper() {
        val endPoint = "search/photos?page=1&query=$category&per_page=30&client_id=$API_KEY"
        viewModelScope.launch {
            try {
                val data = wallpaperRepo.getWallpaper(endPoint)
                wallpaperStatus = WallpaperStatus.Success(WallpaperState(data))
            } catch (e: Exception) {
                wallpaperStatus = WallpaperStatus.Error(e.message.toString())
            } catch (e: IOException) {
                wallpaperStatus = WallpaperStatus.Error(e.message.toString())
            }
        }
    }


}

data class WallpaperState(
    val wallpaper: WallpaperModel
)