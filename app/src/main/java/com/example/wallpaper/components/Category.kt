package com.example.wallpaper.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wallpaper.network.viewmodels.WallpaperViewModel

val list = listOf("Animals", "Sports", "Travel", "HD Wallpaper", "4K Wallpaper")

@Composable
fun Category(modifier: Modifier = Modifier) {
    val vm: WallpaperViewModel = hiltViewModel()


    LazyRow(
        modifier = modifier.fillMaxWidth()
    ) {
        items(list.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(
                        if (vm.isCategorySelected == it) MaterialTheme.colorScheme.errorContainer else Color.Gray.copy(
                            alpha = 0.3f
                        )
                    )
                    .clickable {
                        vm.isCategorySelected = it
                        vm.fetchWallpaper()
                        vm.updateCategory(list[it])
                    }
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = list[it], style = MaterialTheme.typography.bodySmall)
            }
        }
    }

}