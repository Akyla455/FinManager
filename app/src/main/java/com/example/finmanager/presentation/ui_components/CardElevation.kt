package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardElevation(
    modifier: Modifier = Modifier,
    title: String,
    value: String
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.LightGray, Color.White)
                    )
                )
                .padding(16.dp),
            //contentAlignment = Alignment.Center
        ){
            Text(
                modifier = modifier.align(Alignment.CenterStart),
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = modifier.align(Alignment.CenterEnd),
                text = value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }

}