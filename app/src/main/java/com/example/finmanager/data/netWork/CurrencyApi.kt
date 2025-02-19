package com.example.finmanager.data.netWork

import com.example.finmanager.data.model.DataCurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("latest.json")
    suspend fun getCurrency(@Query("app_id") appId: String): DataCurrencyResponse

}