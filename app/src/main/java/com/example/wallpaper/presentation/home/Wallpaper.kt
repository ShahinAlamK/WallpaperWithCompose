package com.example.wallpaper.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wallpaper.components.Category
import com.example.wallpaper.components.ImageCard


@Composable
fun Wallpaper(
    paddingValues: PaddingValues,
    onNavigateTO: (String) -> Unit,
    wallpaperState: HomeUiState
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Category()
        Spacer(modifier = Modifier.size(20.dp))
        LoadWallpaper(onNavigateTO = onNavigateTO, wallpaperList = wallpaperState)
    }


}


@Composable
fun LoadWallpaper(
    modifier: Modifier = Modifier,
    onNavigateTO: (String) -> Unit,
    wallpaperList: HomeUiState
) {

    val state = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        state = state,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        items(wallpaperList.dataList.size) { index ->
            val image = wallpaperList.dataList[index]
            ImageCard(
                imageUrl = image.urls!!.thumb!!,
                onClick = { onNavigateTO(image.urls.regular!!) }
            )
        }
    }
}






