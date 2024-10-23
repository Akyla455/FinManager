package com.example.finmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.finmanager.presentation.navigation.Navigation
import com.example.finmanager.presentation.screens.MainScreen
import com.example.finmanager.presentation.ui.theme.FinManagerTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinManagerTheme {
                    Navigation()
            }
        }
    }
}


