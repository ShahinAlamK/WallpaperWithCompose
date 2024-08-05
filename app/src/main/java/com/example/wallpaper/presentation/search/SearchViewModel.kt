package com.example.wallpaper.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.common.UtilsApi
import com.example.wallpaper.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: WallpaperRepo) : ViewModel() {

    var wallpaperStatus by mutableStateOf<Resource>(Resource.Loading)

    var searchText by mutableStateOf("nature")
    fun updateSearchText(text: String) {
        searchText = text

    }

    fun getSearchWallpaper() {
        val query = "search/photos?page=1&query=$searchText&per_page=30&client_id=${UtilsApi.API_KEY}"
        viewModelScope.launch {
            try {
                val response = repository.searchWallpaper(query)
                wallpaperStatus = Resource.Success(WallpaperState(response))
            } catch (e: Exception) {
                wallpaperStatus = Resource.Error(e.message.toString())
            }
        }
    }

}*/
