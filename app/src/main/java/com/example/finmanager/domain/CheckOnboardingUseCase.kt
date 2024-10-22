package com.example.finmanager.domain

import com.example.finmanager.data.PreferencesManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckOnboardingUseCase@Inject constructor(private val preferencesManager: PreferencesManager) {
    fun execute(): Flow<Boolean> = preferencesManager.onboardingCompleted
}