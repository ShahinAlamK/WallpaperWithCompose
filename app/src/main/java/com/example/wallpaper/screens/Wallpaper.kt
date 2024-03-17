package com.example.wallpaper.screens

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
import androidx.navigation.NavController
import com.example.wallpaper.components.Category
import com.example.wallpaper.components.ImageCard
import com.example.wallpaper.navGraph.RouteItem


@Composable
fun Wallpaper(paddingValues: PaddingValues,nav: NavController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Category()
        Spacer(modifier = Modifier.size(20.dp))
        LoadWallpaper(nav = nav)
    }

}


@Composable
fun LoadWallpaper(nav: NavController) {
    val list = listOf(
        "https://c4.wallpaperflare.com/wallpaper/695/331/660/digital-art-artwork-women-cityscape-wallpaper-preview.jpg",
        "https://images.unsplash.com/photo-1709983967481-d738b90bd395?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710169589950-ee8c3be7cbef?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxM3x8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710461638555-27795861894f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710302112350-e14ceae0c385?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710372165237-2a2ada353c15?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOXx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710432157411-dcaa1c5b9494?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0NHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710156348905-0f632a11ce3a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw5MHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710209614924-6bf12ec19b85?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw3MHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710228010417-a8d07002b83c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1OXx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1710432157411-dcaa1c5b9494?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0NHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1709634539435-f9fccaf0fda1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMTN8fHxlbnwwfHx8fHw%3D",
        "https://images.unsplash.com/photo-1710104434504-0261d06fa832?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMTl8fHxlbnwwfHx8fHw%3D"
    )

    val state = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        state = state,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        items(list.size) {
            ImageCard(
                imageUrl = list[it],
                onClick = {
                    nav.navigate(RouteItem.Details.route)
                }
            )
        }

    }
}






