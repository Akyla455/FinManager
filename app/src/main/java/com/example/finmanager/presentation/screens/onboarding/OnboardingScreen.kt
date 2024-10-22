package com.example.finmanager.presentation.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finmanager.R
import com.example.finmanager.presentation.ui_components.BackButton
import com.example.finmanager.presentation.ui_components.BoltText
import com.example.finmanager.presentation.ui_components.NextButton
import com.example.finmanager.presentation.ui_components.OnboardingImage
import com.example.finmanager.presentation.ui_components.SegmentBar


@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit
){
    val onboardingPages = listOf(
        OnboardingPage(R.drawable.ic_fast, R.string.fast),
        OnboardingPage(R.drawable.ic_wallet, R.string.accounting),
        OnboardingPage(R.drawable.ic_currency, R.string.currency_rate)
    )
    var currentPage by remember {
        mutableIntStateOf(0)
    }
    
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OnboardingImage(
            image = onboardingPages[currentPage].image,
            modifier = modifier.padding(top = 50.dp)
        )
        BoltText(
            modifier = modifier.padding(top = 30.dp),
            text = onboardingPages[currentPage].text
        )
        SegmentBar(
            currentPage = currentPage,
            totalSegments = onboardingPages.size,
            modifier = modifier.padding(top = 50.dp)
        )
        Row (
            modifier = modifier.padding(top = 35.dp)
        ) {
            if(currentPage > 0){
                BackButton (
                    onClick = {
                        currentPage--
                    },
                    modifier = modifier.padding(end = 8.dp)
                )
            }
            NextButton(
                onClick = {
                    if(currentPage < onboardingPages.size -1){
                        currentPage++
                    } else {
                        onComplete()
                    }

                },
                text = R.string.next,
            )
        }

    }
}