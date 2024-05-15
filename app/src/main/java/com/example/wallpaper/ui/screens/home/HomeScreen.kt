package com.example.wallpaper.ui.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wallpaper.R
import com.example.wallpaper.components.Error
import com.example.wallpaper.components.LoadingComponent
import com.example.wallpaper.components.RoundIcon
import com.example.wallpaper.network.utils.WallpaperStatus
import com.example.wallpaper.network.viewmodels.WallpaperViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail: (String) -> Unit,
) {
    val wallpaperViewModel: WallpaperViewModel = hiltViewModel()
    val wallpaperSate = wallpaperViewModel.wallpaperStatus

    LaunchedEffect(key1 = true) {
        wallpaperViewModel.fetchWallpaper()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = { Text(text = "Wallpaper", style = MaterialTheme.typography.titleLarge) },
                actions = {

                    RoundIcon(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = ""
                            )
                        },
                        onClick = { /*TODO*/ }
                    )
                    Spacer(modifier = Modifier.size(20.dp))

                    RoundIcon(
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = ""
                            )
                        },
                        onClick = { /*TODO*/ }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                }
            )
        }
    ) { paddingValues ->
        when (wallpaperSate) {
            is WallpaperStatus.Loading -> {
               LoadingComponent()
            }

            is WallpaperStatus.Error -> {
                Error(error = wallpaperViewModel.wallpaperStatus.toString())
            }

            is WallpaperStatus.Empty -> {
                Text(text = "Empty")
            }
            is WallpaperStatus.Success ->{
                Wallpaper(paddingValues, onNavigateTO = onNavigateToDetail, wallpaperState = wallpaperSate.data)
            }
        }


    }
}