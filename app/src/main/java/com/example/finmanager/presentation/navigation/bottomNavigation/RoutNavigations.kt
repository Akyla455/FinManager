package com.example.finmanager.presentation.navigation.bottomNavigation

import com.example.finmanager.R

sealed class Screen(val route: String, val title: String, val icon: Int){
    data object Home: Screen("home", "Home", R.drawable.ic_home)
    data object Statistic: Screen("statistic", "Statistic", R.drawable.ic_statistic_vector)
    data object Currency: Screen("currency", "Currency", R.drawable.ic_dollar)
}