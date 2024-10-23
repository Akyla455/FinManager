package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SmallTransparentText(
    modifier: Modifier = Modifier,
    text: Int,
    onClick: () -> Unit = {},
    color: Color = Color.Gray
) {
    Text(
        text = stringResource(text),
        modifier = modifier
            .clickable {
                onClick()
            },
        fontSize = 13.sp,
        color = color,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Light
    )
}