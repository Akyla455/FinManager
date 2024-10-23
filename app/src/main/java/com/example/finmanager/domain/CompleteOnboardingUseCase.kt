package com.example.finmanager.domain

import com.example.finmanager.data.PreferencesManager
import javax.inject.Inject

class CompleteOnboardingUseCase @Inject constructor(private val preferencesManager: PreferencesManager) {
    suspend fun execute(){
        preferencesManager.setOnboardingCompleted()
    }
}