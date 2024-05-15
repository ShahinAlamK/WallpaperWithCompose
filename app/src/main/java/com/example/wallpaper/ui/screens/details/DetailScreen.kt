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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.wallpaper.R
import com.example.wallpaper.components.RoundIcon

@Composable
fun DetailScreen(nav: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = "https://images.unsplash.com/photo-1709983967481-d738b90bd395?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = ""
        )

        Row(
            modifier = Modifier.statusBarsPadding()
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
                },
                onClick = { nav.popBackStack() })

            RoundIcon(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = ""
                    )
                },
                onClick = {})
        }

        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.3f),
                    contentColor = MaterialTheme.colorScheme.onBackground,
                ),
                shape = MaterialTheme.shapes.extraLarge,
                elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
                onClick = { }) {
                Text(text = "Set Wallpaper", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.size(10.dp))
            TextButton(onClick = { nav.popBackStack()}) {
                Text(text = "Cancel", style = MaterialTheme.typography.bodyMedium)
            }
        }

    }
}