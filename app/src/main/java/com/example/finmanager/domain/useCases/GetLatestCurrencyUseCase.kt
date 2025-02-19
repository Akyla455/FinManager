package com.example.finmanager.domain.useCases

import com.example.finmanager.domain.CurrencyRepository
import com.example.finmanager.domain.model.DataCurrency
import javax.inject.Inject

class GetLatestCurrencyUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    suspend operator fun invoke(): DataCurrency{
        return repository.getLatestCurrency()
    }
}