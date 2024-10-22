package com.example.finmanager.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.finmanager.data.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesManager @Inject constructor
    (private val dataStore: DataStore<Preferences>) {

    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
        private val LOGIN_KEY = stringPreferencesKey("login")
        private val PASSWORD_KEY = stringPreferencesKey("password")
    }

    val onboardingCompleted: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] ?: false
        }

    val userPreferences: Flow<UserPreferences> = dataStore.data
        .map { preferences ->
            val long = preferences[LOGIN_KEY] ?: ""
            val password = preferences[PASSWORD_KEY] ?: ""
            UserPreferences(long, password)
        }

    suspend fun setOnboardingCompleted(){
        dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] = true
        }
    }

    suspend fun saveUserPreferences(login: String, password: String){
        dataStore.edit { preferences ->
            preferences[LOGIN_KEY] = login
            preferences[PASSWORD_KEY] = password
        }
    }

}