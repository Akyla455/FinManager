package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finmanager.presentation.ui.theme.ModeratelyBlue
import com.example.finmanager.presentation.ui.theme.SecondaryColor

@Composable
fun DualCircles(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Canvas(modifier = Modifier
            .size(25.dp)
        ) {
            drawCircle(
                color = SecondaryColor,
                radius = 25.dp.toPx(),
                center = center.copy(x = center.x + 120)
            )
        }
        Canvas(modifier = Modifier
            .size(25.dp)
        ) {
            drawCircle(
                color = ModeratelyBlue,
                radius = 25.dp.toPx(),
                center = center.copy(x = center.x - 35)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDualCircles(){
    DualCircles()
}