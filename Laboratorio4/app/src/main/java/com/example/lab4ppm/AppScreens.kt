package com.example.lab4ppm

sealed class AppScreens(val route: String) {
    object LoginScreen:AppScreens("login_screen")
    object RegisterScreen:AppScreens("register_screen")
    object MenuScreen:AppScreens("menu_screen")
}