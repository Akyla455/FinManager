package com.example.finmanager.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed interface OnboardingState{
    data object Start: OnboardingState
    data object Onboarding: OnboardingState
}

class OnboardingViewModel: ViewModel() {

    private val _onboardingState = MutableStateFlow<OnboardingState>(OnboardingState.Start)
    val onboardingState: StateFlow<OnboardingState>
        get() = _onboardingState

    fun startOnboarding(intent: OnboardingIntent){
        when(intent){
            is OnboardingIntent.Onboarding -> _onboardingState.value = OnboardingState.Onboarding
        }
    }
}