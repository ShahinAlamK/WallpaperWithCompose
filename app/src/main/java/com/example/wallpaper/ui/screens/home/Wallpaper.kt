package com.example.wallpaper.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wallpaper.components.Category
import com.example.wallpaper.components.Error
import com.example.wallpaper.components.ImageCard
import com.example.wallpaper.components.LoadingComponent
import com.example.wallpaper.navGraph.RouteItem
import com.example.wallpaper.network.models.WallpaperModel
import com.example.wallpaper.network.utils.WallpaperStatus
import com.example.wallpaper.network.viewmodels.WallpaperState
import com.example.wallpaper.network.viewmodels.WallpaperViewModel


@Composable
fun Wallpaper(
    paddingValues: PaddingValues,
    onNavigateTO: (String) -> Unit,
    wallpaperState: WallpaperState
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
    wallpaperList: WallpaperState
) {

    val state = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        state = state,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        items(wallpaperList.wallpaper.results?.size!!) { index ->
            val image = wallpaperList.wallpaper.results[index]!!
            ImageCard(
                imageUrl =image.urls?.regular!!,
                onClick = {onNavigateTO(image.urls.raw!!)}
            )

        }


    }
}






