package com.example.finmanager.presentation.screens.currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.finmanager.R
import com.example.finmanager.presentation.ui.theme.Plum
import com.example.finmanager.presentation.ui_components.BoltText
import com.example.finmanager.presentation.ui_components.CardElevation
import com.example.finmanager.presentation.ui_components.NextButton

@Composable
fun CurrencyScreen(
    modifier: Modifier = Modifier,
    viewModel: CurrencyViewModel = hiltViewModel()

) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchLatestCurrency()
    }

    when (state) {
        is CurrencyState.Loading -> {
            Column(
                modifier
                    .fillMaxSize()
                    .background(color = Plum),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is CurrencyState.Success -> {
            val data = (state as CurrencyState.Success).currency
            LazyColumn(
                modifier
                    .fillMaxSize()
                    .background(color = Plum)
            ) {
                items(data.rates.toList(), key = { it.first }) { (currency, rate) ->
                    CardElevation(
                        modifier = modifier,
                        title = currency,
                        value = rate.toString()
                    )
                }
            }
        }

        is CurrencyState.Error -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Plum),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BoltText(
                    modifier = modifier.padding(25.dp),
                    text = R.string.error
                )
                NextButton(
                    onClick = { viewModel.fetchLatestCurrency() },
                    text = R.string.repeat
                )
            }
        }

    }
}