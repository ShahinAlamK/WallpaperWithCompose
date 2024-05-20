package com.example.wallpaper.navGraph

sealed class RouteItem(val route:String) {
    data object Home:RouteItem("home_screen")
    data object Search:RouteItem("search_screen")
    data object Details:RouteItem("details_screen")
}