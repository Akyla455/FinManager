package com.example.finmanager.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.finmanager.data.PreferencesManager
import com.example.finmanager.domain.CheckOnboardingUseCase
import com.example.finmanager.domain.ValidateLoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context)
    : DataStore<Preferences>{
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile("user_prefs")
        }
    }

    @Provides
    @Singleton
    fun providePreferencesManager(dataStore: DataStore<Preferences>)
    : PreferencesManager{
        return PreferencesManager(dataStore)
    }
    @Provides
    @Singleton
    fun provideCompletedOnboardingUseCase(preferencesManager: PreferencesManager)
    : CheckOnboardingUseCase{
        return CheckOnboardingUseCase(preferencesManager)
    }

    @Provides
    @Singleton
    fun provideValidateLoginUseCase(): ValidateLoginUseCase{
        return ValidateLoginUseCase()
    }
}