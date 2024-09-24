package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.finmanager.R
import com.example.finmanager.presentation.ui.theme.ModeratelyBlue

@Composable
fun MulticoloredText(
    modifier: Modifier = Modifier,
    offset: Dp

) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append(stringResource(R.string.welcome))
        }
        append("\n")

        withStyle(style = SpanStyle(color = Color.Transparent)) {
            append("\n")
        }
        withStyle(style = SpanStyle(color = ModeratelyBlue)) {
            append(stringResource(R.string.app_name))
        }
    }
    Text(
        modifier = modifier
            .offset(y = offset)
            .fillMaxWidth(),
        text = annotatedString,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}