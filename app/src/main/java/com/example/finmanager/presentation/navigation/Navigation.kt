package com.example.finmanager.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finmanager.presentation.screens.MainScreen
import com.example.finmanager.presentation.screens.Profile
import com.example.finmanager.presentation.screens.WelcomeScreen
import com.example.finmanager.presentation.screens.authorization.AuthScreen
import com.example.finmanager.presentation.screens.authorization.RegisterScreen
import com.example.finmanager.presentation.screens.onboarding.OnboardingScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteNavigate.WELCOME){
        composable(RouteNavigate.WELCOME){
            WelcomeScreen(navController)
        }
        composable(RouteNavigate.MAIN){
            MainScreen(navController = navController)
        }
        composable(RouteNavigate.PROFILE) {
            Profile()
        }
        composable(RouteNavigate.AUTHORIZATION) {
            AuthScreen(navController = navController)
        }
        composable(RouteNavigate.REGISTRATION) {
            RegisterScreen(navController = navController)
        }
    }
}