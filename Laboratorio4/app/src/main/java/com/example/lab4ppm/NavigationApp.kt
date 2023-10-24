package com.example.lab4ppm

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4ppm.AppScreens

@Composable
fun NavigationApp(){
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(route = AppScreens.LoginScreen.route){
            LoginLayout(navController)
        }

        composable(route = AppScreens.RegisterScreen.route){
            RegisterLayout(navController)
        }

        composable(route = AppScreens.MenuScreen.route){
            MenuLayout(navController)
        }
    }
}