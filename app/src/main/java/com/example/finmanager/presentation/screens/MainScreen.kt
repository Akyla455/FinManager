package com.example.finmanager.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finmanager.presentation.screens.authorization.AuthorizationScreen
import com.example.finmanager.presentation.screens.onboarding.OnboardingScreen

@Composable
fun MainScreen(
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavController
){

    val onboardingCompleted = authViewModel.onboardingCompleted
    val isAuthenticated = authViewModel.isAuthenticated

    when{
        !onboardingCompleted -> {
            OnboardingScreen( onComplete = {
                authViewModel.completeOnboarding()
            })
        }
        !isAuthenticated -> {
            AuthorizationScreen(navController = navController)
        }
    }
}