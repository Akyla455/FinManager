package com.example.finmanager.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finmanager.presentation.navigation.bottomNavigation.BottomBar
import com.example.finmanager.presentation.navigation.bottomNavigation.Screen
import com.example.finmanager.presentation.screens.currency.CurrencyScreen
import com.example.finmanager.presentation.screens.onboarding.OnboardingScreen

@Composable
fun MainScreen(
    onboardingViewModel: OnboardingViewModel = hiltViewModel()
){
    val navController = rememberNavController()
    val items = listOf(Screen.Home, Screen.Statistic, Screen.Currency)

    val onboardingCompleted by onboardingViewModel.onboardingCompleted.collectAsState()
    val isLoading by onboardingViewModel.isLoading.collectAsState()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    when{
        isLoading -> {
            WelcomeScreen()
        }
        else -> {
            if(!onboardingCompleted){
                OnboardingScreen(onComplete = {
                    onboardingViewModel.completeOnboarding()
                })
            } else {
                Scaffold(
                    bottomBar = {
                        BottomBar(
                            currentRoute = currentRoute,
                            items = items,
                            onNavigate = { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Home.route) { HomeScreen() }
                        composable(Screen.Statistic.route) { StatisticScreen() }
                        composable(Screen.Currency.route) { CurrencyScreen() }
                    }
                }
            }
        }
    }
}