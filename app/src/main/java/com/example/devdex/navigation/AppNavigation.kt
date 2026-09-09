package com.example.devdex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.devdex.presentation.LoginScreen
import com.example.devdex.presentation.SignUpScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login_screen") {
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("sign_up_screen") {
            SignUpScreen()
        }
    }
}