package com.example.wallpaper.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallpaper.presentation.home.WallpaperViewModel
import com.example.wallpaper.presentation.details.DetailScreen
import com.example.wallpaper.presentation.home.HomeScreen
import com.example.wallpaper.presentation.search.SearchScreen

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