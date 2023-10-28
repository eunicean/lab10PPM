package com.example.lab4ppm

sealed class AppScreens(val route: String) {
    object LoginScreen:AppScreens("login_screen")
    object SignUpScreen:AppScreens("register_screen")
    object MenuScreen:AppScreens("menu_screen")
    object LoginWGScreen:AppScreens("loginwg_screen")
}