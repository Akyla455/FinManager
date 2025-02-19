package com.example.finmanager.data.mapper

import com.example.finmanager.data.model.DataCurrencyResponse
import com.example.finmanager.domain.model.DataCurrency

fun DataCurrencyResponse.toDomain(): DataCurrency{
    return DataCurrency(
        rates = rates
    )
}