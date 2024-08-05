package com.example.wallpaper.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.components.list
import com.example.wallpaper.common.Resource
import com.example.wallpaper.common.UtilsApi.API_KEY
import com.example.wallpaper.domain.use_case.GetWallpaperUseCase
import com.example.wallpaper.mapper.toUnsplash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(
    private val getWallpaperUseCase: GetWallpaperUseCase
) : ViewModel() {

    private var category = list[0]

    var isCategorySelected by mutableIntStateOf(0)
    fun updateCategory(newCategory: String) {
        category = newCategory
        fetchWallpaper()
    }

    var wallpaperStatus by mutableStateOf(HomeUiState())
        private set

    var detailsImage by mutableStateOf("")

    fun updateDetailsImage(newDetailsImage: String) {
        detailsImage = newDetailsImage
    }

    init {
        fetchWallpaper()
    }

    private fun fetchWallpaper() {
        getWallpaperUseCase(
            page = 1,
            query = category,
            perPage = 30,
            clientId = API_KEY
        ).onEach {
            wallpaperStatus = when (it) {
                is Resource.Error -> {
                    HomeUiState(error = it.error!!.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    HomeUiState(loading = true)
                }

                is Resource.Success -> {
                    HomeUiState(dataList = it.data!!)
                }
            }
        }.launchIn(viewModelScope)

    }


}