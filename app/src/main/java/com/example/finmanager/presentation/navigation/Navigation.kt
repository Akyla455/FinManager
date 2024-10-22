package com.example.finmanager.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finmanager.presentation.screens.WelcomeScreen
import com.example.finmanager.presentation.screens.onboarding.OnboardingScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteNavigate.WELCOME){
        composable(RouteNavigate.WELCOME){
            WelcomeScreen(navController)
        }
        composable(RouteNavigate.ONBOARDING){
            OnboardingScreen(navController)
        }
    }
}