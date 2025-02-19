package com.example.finmanager.data.model

import com.google.gson.annotations.SerializedName

data class DataCurrencyResponse(
    val rates: Map<String, Double>
)
