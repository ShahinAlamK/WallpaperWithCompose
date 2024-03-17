package com.example.wallpaper.components

import androidx.compose.foundation.background
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

@Composable
fun Category() {
    val list = listOf("Animals", "Sports", "Travel", "HD Wallpaper", "4K Wallpaper")

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(list.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(Color.Gray.copy(alpha = 0.3f))
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = list[it], style = MaterialTheme.typography.bodySmall)
            }
        }
    }

}