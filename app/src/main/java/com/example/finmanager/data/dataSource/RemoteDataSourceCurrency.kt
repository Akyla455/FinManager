package com.example.finmanager.data.dataSource

import com.example.finmanager.data.model.DataCurrencyResponse
import com.example.finmanager.data.netWork.CurrencyApi
import javax.inject.Inject

class RemoteDataSourceCurrency @Inject constructor(
    private val api: CurrencyApi
) {
    suspend fun getLatestCurrency(appId: String): DataCurrencyResponse {
        return api.getCurrency(appId)
    }
}