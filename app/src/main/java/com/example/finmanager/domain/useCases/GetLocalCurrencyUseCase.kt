package com.example.finmanager.domain.useCases

import com.example.finmanager.domain.CurrencyRepository
import com.example.finmanager.domain.model.DataCurrency
import javax.inject.Inject


class GetLocalCurrencyUseCase @Inject constructor(private val repo: CurrencyRepository) {
    suspend operator fun invoke(): DataCurrency{
        return repo.getLocalCurrency()
    }
}