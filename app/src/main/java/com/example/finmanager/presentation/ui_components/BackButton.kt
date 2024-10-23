package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finmanager.R

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.moderately_blue)
        ),
        shape = CircleShape,
        modifier = modifier.size(60.dp),
        onClick = { onClick() },
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = null,
            //modifier = modifier.size(40.dp)
        )
    }
}