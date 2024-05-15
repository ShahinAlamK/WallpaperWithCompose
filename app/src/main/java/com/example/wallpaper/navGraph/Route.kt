package com.example.wallpaper.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wallpaper.ui.screens.details.DetailScreen
import com.example.wallpaper.ui.screens.home.HomeScreen

@Composable
fun Route(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = RouteItem.Home.route) {

        composable(RouteItem.Home.route){
            HomeScreen(nav = navHostController)
        }

        composable(RouteItem.Details.route){
            DetailScreen(nav = navHostController)
        }


    }
}