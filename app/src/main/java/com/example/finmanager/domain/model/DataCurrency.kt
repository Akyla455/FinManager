package com.example.finmanager.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class DataCurrency(
    val rates: Map<String, Double>
)
