package com.example.wallpaper.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wallpaper.R

@Composable
fun ImageCard(
    imageUrl: String,
    onClick:()-> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick()}
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
            model = imageUrl,
            contentDescription = null,
        )

        RoundIcon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = ""
                )
            },
            onClick = { /*TODO*/ }
        )
    }
}