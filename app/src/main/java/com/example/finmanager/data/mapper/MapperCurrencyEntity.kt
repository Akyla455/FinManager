package com.example.finmanager.data.mapper

import com.example.finmanager.data.model.CurrencyEntity
import com.example.finmanager.domain.model.DataCurrency

fun List<CurrencyEntity>.toDomain(): DataCurrency{
    val ratesMap = this.associate { it.currency to it.rate }
    return DataCurrency(rates = ratesMap)
}