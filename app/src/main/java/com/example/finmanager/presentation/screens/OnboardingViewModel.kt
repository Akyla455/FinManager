package com.example.finmanager.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finmanager.domain.useCases.CheckOnboardingUseCase
import com.example.finmanager.domain.useCases.CompleteOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val completeOnboardingUseCase: CompleteOnboardingUseCase,
    private val checkOnboardingUseCase: CheckOnboardingUseCase
) : ViewModel() {

    private var _onboardingCompleted = MutableStateFlow(false)
    val onboardingCompleted: StateFlow<Boolean> = _onboardingCompleted

    private var _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            checkOnboardingUseCase.execute().collect{ completed ->
                _onboardingCompleted.value = completed
                delay(2500)
                _isLoading.value = false
            }
        }
    }

    fun completeOnboarding(){
        viewModelScope.launch {

            completeOnboardingUseCase.execute()
            _onboardingCompleted.value = true
        }
    }
}