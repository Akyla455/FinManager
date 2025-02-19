package com.example.finmanager.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.finmanager.data.PreferencesManager
import com.example.finmanager.data.dataBase.CurrencyDao
import com.example.finmanager.data.dataBase.CurrencyDataBase
import com.example.finmanager.data.dataSource.LocalDataSourceCurrency
import com.example.finmanager.data.netWork.CurrencyApi
import com.example.finmanager.data.dataSource.RemoteDataSourceCurrency
import com.example.finmanager.data.repository.CurrencyRepositoryImp
import com.example.finmanager.domain.useCases.CheckOnboardingUseCase
import com.example.finmanager.domain.CurrencyRepository
import com.example.finmanager.domain.useCases.GetLatestCurrencyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    : CheckOnboardingUseCase {
        return CheckOnboardingUseCase(preferencesManager)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): CurrencyApi{
        return Retrofit.Builder()
            .baseUrl("https://openexchangerates.org/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSourceCurrency(api: CurrencyApi): RemoteDataSourceCurrency{
        return RemoteDataSourceCurrency(api)
    }

    @Provides
    @Singleton
    fun provideLocalDataSourceCurrency(dao: CurrencyDao): LocalDataSourceCurrency{
        return LocalDataSourceCurrency(dao)
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(
        remoteDataSourceCurrency: RemoteDataSourceCurrency,
        localDataSource: LocalDataSourceCurrency
    ): CurrencyRepository {
        return CurrencyRepositoryImp(remoteDataSourceCurrency, localDataSource)
    }

    @Provides
    @Singleton
    fun provideGetLatestCurrencyUseCase(
        repository: CurrencyRepository
    ): GetLatestCurrencyUseCase{
        return GetLatestCurrencyUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CurrencyDataBase{
        return Room.databaseBuilder(
            context,
            CurrencyDataBase::class.java,
            "currency"
        ).build()
    }

    @Provides
    fun provideCurrencyDao(dataBase: CurrencyDataBase): CurrencyDao {
        return dataBase.currencyDao()
    }

}