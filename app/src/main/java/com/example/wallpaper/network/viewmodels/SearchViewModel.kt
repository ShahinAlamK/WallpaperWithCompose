package com.example.wallpaper.network.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.network.repository.WallpaperRepo
import com.example.wallpaper.network.utils.UtilsApi
import com.example.wallpaper.network.utils.WallpaperStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: WallpaperRepo) : ViewModel() {

    var wallpaperStatus by mutableStateOf<WallpaperStatus>(WallpaperStatus.Loading)

    var searchText by mutableStateOf("nature")
    fun updateSearchText(text: String) {
        searchText = text

    }

    fun getSearchWallpaper() {
        val query = "search/photos?page=1&query=$searchText&per_page=30&client_id=${UtilsApi.API_KEY}"
        viewModelScope.launch {
            try {
                val response = repository.searchWallpaper(query)
                wallpaperStatus = WallpaperStatus.Success(WallpaperState(response))
            } catch (e: Exception) {
                wallpaperStatus = WallpaperStatus.Error(e.message.toString())
            }
        }
    }

}