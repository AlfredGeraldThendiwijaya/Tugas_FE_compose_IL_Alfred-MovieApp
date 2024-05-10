package com.example.myapplication

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Favorite : Screens("favorite_screen")
    object Profile : Screens("profile_screen")
    object Detail : Screens("detail_screen")
}