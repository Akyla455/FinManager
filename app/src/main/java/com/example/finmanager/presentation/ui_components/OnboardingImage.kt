package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingImage(
    modifier: Modifier = Modifier,
    image: Int
){
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .size(250.dp)
    )
}