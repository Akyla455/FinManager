package com.example.finmanager.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finmanager.data.PreferencesManager
import com.example.finmanager.domain.CheckOnboardingUseCase
import com.example.finmanager.domain.CompleteOnboardingUseCase
import com.example.finmanager.domain.ValidateLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userPreferencesManager: PreferencesManager,
    private val validateLoginUseCase: ValidateLoginUseCase,
    private val completeOnboardingUseCase: CompleteOnboardingUseCase,
    private val checkOnboardingUseCase: CheckOnboardingUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            checkOnboardingUseCase.execute().collect{ completed ->
                onboardingCompleted = completed
            }

            userPreferencesManager.userPreferences.collect{ preferences ->
                login = preferences.login
                password = preferences.password
            }
        }
    }

    private var login by mutableStateOf("")
    private var password by mutableStateOf("")
    var isAuthenticated by mutableStateOf(false)
    var onboardingCompleted by mutableStateOf(false)

    fun onRegisterChanged(newLogin: String, newPassword: String){
        login = newLogin
        password = newPassword
        saveLogin()
    }

    private fun saveLogin(){
        if(validateLoginUseCase.execute(login, password)){
            viewModelScope.launch {
                userPreferencesManager.saveUserPreferences(login, password)
            }
        }
    }

    fun completeOnboarding(){
        viewModelScope.launch {
            completeOnboardingUseCase.execute()
            onboardingCompleted = true
        }
    }
}