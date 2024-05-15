package com.example.wallpaper.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wallpaper.R
import com.example.wallpaper.components.RoundIcon
import com.example.wallpaper.network.viewmodels.WallpaperViewModel

@Composable
fun DetailScreen(
    id: String, onNavigateBack: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current).data(id).crossfade(true).build(),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            imageLoader = ImageLoader(LocalContext.current),
            placeholder = painterResource(id = R.drawable.baseline_loop_24),
            )

        Row(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundIcon(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = ""
                    )
                }, onClick = onNavigateBack
            )

            RoundIcon(icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = ""
                )
            }, onClick = {})
        }

        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.3f),
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
                shape = MaterialTheme.shapes.extraLarge,
                elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
                onClick = { }) {
                Text(text = "Set Wallpaper", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.size(10.dp))
            TextButton(onClick = onNavigateBack) {
                Text(text = "Cancel", style = MaterialTheme.typography.bodyMedium)
            }
        }

    }
}