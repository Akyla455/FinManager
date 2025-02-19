package com.example.finmanager.data.repository

import com.example.finmanager.data.dataSource.LocalDataSourceCurrency
import com.example.finmanager.data.mapper.toDomain
import com.example.finmanager.data.model.CurrencyEntity
import com.example.finmanager.data.dataSource.RemoteDataSourceCurrency
import com.example.finmanager.domain.CurrencyRepository
import com.example.finmanager.domain.model.DataCurrency
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class CurrencyRepositoryImp @Inject constructor(
    private val remoteDataSourceCurrency: RemoteDataSourceCurrency,
    private val localDataSource: LocalDataSourceCurrency
) : CurrencyRepository {

    private val appId = "686b5827047e4e33bdc06effd904e56d"

    private val mutex = Mutex()

    override suspend fun getLatestCurrency(): DataCurrency {
        mutex.withLock {
            val localRates = localDataSource.getAllRates()

            val response = remoteDataSourceCurrency.getLatestCurrency(appId)

            if (response.rates.isNotEmpty()) {
                val currencyRates = response.rates.map { (currency, rate) ->
                    CurrencyEntity(
                        currency = currency,
                        rate = rate
                    )
                }

                if (localRates.isEmpty()) {
                    localDataSource.saveCurrencyRates(currencyRates)
                } else {
                    localDataSource.updateCurrency(currencyRates)
                }
            }

            return response.toDomain()
        }
    }

    override suspend fun getLocalCurrency(): DataCurrency {
        val localResponse = localDataSource.getAllRates()
       return localResponse.toDomain()
    }
}