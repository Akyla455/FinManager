package com.example.finmanager.data.dataSource

import com.example.finmanager.data.dataBase.CurrencyDao
import com.example.finmanager.data.model.CurrencyEntity
import javax.inject.Inject


class LocalDataSourceCurrency @Inject constructor(
    private val currencyDao: CurrencyDao
) {
    suspend fun getAllRates(): List<CurrencyEntity> {
        return currencyDao.getCurrency()
    }

    suspend fun saveCurrencyRates(rates: List<CurrencyEntity>){
        currencyDao.insertCurrency(rates)
    }

    suspend fun updateCurrency(rates: List<CurrencyEntity>){
        currencyDao.updateCurrency(rates)
    }
}