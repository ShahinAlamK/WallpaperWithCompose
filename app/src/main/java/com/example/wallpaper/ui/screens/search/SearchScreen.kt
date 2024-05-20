package com.example.wallpaper.ui.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wallpaper.components.Error
import com.example.wallpaper.components.LoadingComponent
import com.example.wallpaper.network.utils.WallpaperStatus
import com.example.wallpaper.network.viewmodels.SearchViewModel
import com.example.wallpaper.ui.screens.home.LoadWallpaper
import com.example.wallpaper.ui.screens.home.Wallpaper

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onNavigateToDetail: (String) ->Unit
) {
    val vm: SearchViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        vm.getSearchWallpaper()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier.shadow(elevation = 1.dp),
                title = {
                    TextField(
                        value = vm.searchText,
                        onValueChange = {vm.updateSearchText(it)},
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodyLarge,
                        keyboardActions = KeyboardActions(
                            onDone = {vm.getSearchWallpaper()}
                        ),
                        prefix = {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = null
                            )
                        },
                        placeholder = { Text(text = "Search") },
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(end = 20.dp)
                    )
                }
            )
        },
    ) {
        when (val response = vm.wallpaperStatus) {
            is WallpaperStatus.Loading -> {
                LoadingComponent()
            }

            is WallpaperStatus.Error -> {
                Error(error = vm.wallpaperStatus.toString())
            }

            is WallpaperStatus.Empty -> {
                Text(text = "Empty")
            }
            is WallpaperStatus.Success ->{
                LoadWallpaper(
                    modifier = Modifier.padding(it),
                    wallpaperList = response.data,
                    onNavigateTO = onNavigateToDetail
                )
            }
        }
    }
}