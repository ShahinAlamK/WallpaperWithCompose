package com.example.wallpaper.navGraph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wallpaper.network.viewmodels.WallpaperViewModel
import com.example.wallpaper.ui.screens.details.DetailScreen
import com.example.wallpaper.ui.screens.home.HomeScreen

@Composable
fun Route(navHostController: NavHostController = rememberNavController()) {
    val wallpaperViewModel: WallpaperViewModel = hiltViewModel()

    NavHost(navController = navHostController, startDestination = RouteItem.Home.route) {

        composable(RouteItem.Home.route) {
            HomeScreen(
                onNavigateToDetail = {
                    navHostController.navigate(RouteItem.Details.route)
                    wallpaperViewModel.updateDetailsImage(it)
                })
        }

        composable(RouteItem.Details.route,
        ) {
            val id = wallpaperViewModel.detailsImage
            DetailScreen(
                id = id,
                onNavigateBack = { navHostController.popBackStack() }
            )
        }


    }
}