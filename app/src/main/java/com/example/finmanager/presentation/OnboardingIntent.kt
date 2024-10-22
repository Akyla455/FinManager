package com.example.finmanager.presentation

sealed interface OnboardingIntent{
    data object Onboarding: OnboardingIntent
}