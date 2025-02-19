package com.example.finmanager.presentation.screens.currency


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finmanager.domain.model.DataCurrency
import com.example.finmanager.domain.useCases.GetLatestCurrencyUseCase
import com.example.finmanager.domain.useCases.GetLocalCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface CurrencyState{
    data object Loading: CurrencyState
    data class Success(val currency: DataCurrency) : CurrencyState
    data object Error: CurrencyState
}

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getLatestCurrencyUseCase: GetLatestCurrencyUseCase,
    private val getLocalCurrencyUseCase: GetLocalCurrencyUseCase
): ViewModel() {

    private var _state = MutableStateFlow<CurrencyState>(CurrencyState.Loading)
    val state: StateFlow<CurrencyState> = _state

    fun fetchLatestCurrency(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val currency = getLatestCurrencyUseCase()
                _state.value = CurrencyState.Success(currency)

            } catch (e: Exception){
                val localCurrency = getLocalCurrencyUseCase()
                if(localCurrency.rates.isNotEmpty()){
                    _state.value = CurrencyState.Success(localCurrency)
                } else{
                    _state.value = CurrencyState.Error

                }
            }
        }
    }
}