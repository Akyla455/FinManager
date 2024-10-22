package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finmanager.R

@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: Int,
    offset: Dp = 0.dp
){
    Button(
        onClick = { onClick() },
        modifier = modifier
            .size(width = 200.dp, height = 60.dp)
            .offset(y = offset),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.moderately_blue)
        )
    ) {
        Text(
            text = stringResource(text),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}