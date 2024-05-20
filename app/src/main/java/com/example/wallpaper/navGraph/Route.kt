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
import com.example.wallpaper.ui.screens.search.SearchScreen

@Composable
fun Route(navHostController: NavHostController = rememberNavController()) {
    val wallpaperViewModel: WallpaperViewModel = hiltViewModel()

    NavHost(navController = navHostController, startDestination = RouteItem.Home.route) {

        //Home Screen
        composable(RouteItem.Home.route) {
            HomeScreen(
                onNavigateToSearch = { navHostController.navigate(RouteItem.Search.route)},
                onNavigateToDetail = {
                    navHostController.navigate(RouteItem.Details.route)
                    wallpaperViewModel.updateDetailsImage(it)
                })
        }

        //Search Screen
        composable(
            RouteItem.Search.route
        ) {
            SearchScreen(
                onNavigateToDetail = {
                    navHostController.navigate(RouteItem.Details.route)
                    wallpaperViewModel.updateDetailsImage(it)
                }
            )
        }

        //Details Screen
        composable(
            RouteItem.Details.route,
        ) {
            val id = wallpaperViewModel.detailsImage
            DetailScreen(
                id = id,
                onNavigateBack = { navHostController.popBackStack() }
            )
        }


    }
}