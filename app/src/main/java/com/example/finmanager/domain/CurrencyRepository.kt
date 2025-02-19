package com.example.finmanager.domain

import com.example.finmanager.domain.model.DataCurrency

interface CurrencyRepository {

    suspend fun getLatestCurrency(): DataCurrency

    suspend fun getLocalCurrency(): DataCurrency
}