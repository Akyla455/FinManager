package com.example.finmanager.presentation.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finmanager.R
import com.example.finmanager.presentation.navigation.RouteNavigate
import com.example.finmanager.presentation.ui_components.MulticoloredText
import com.example.finmanager.presentation.ui_components.NextButton
import com.example.finmanager.presentation.ui.theme.ModeratelyBlue
import com.example.finmanager.presentation.ui.theme.SecondaryColor
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navController: NavController
) {

    var firstCircleOffsetX by remember { mutableStateOf((-400).dp) }
    var secondCircleOffsetX by remember { mutableStateOf(400.dp) }
    var textOffsetY by remember { mutableStateOf(600.dp) }
    var buttonOffsetY by remember { mutableStateOf((-1000).dp) }

    LaunchedEffect(Unit) {
        delay(300)
        firstCircleOffsetX = 30.dp
        secondCircleOffsetX = (-30).dp

        delay(1000)
        textOffsetY = (-30).dp

        delay(500)
        buttonOffsetY = 120.dp
    }

    val animatedFirstCircleOffsetX by animateDpAsState(
        targetValue = firstCircleOffsetX,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    val animatedSecondCircleOffsetX by animateDpAsState(
        targetValue = secondCircleOffsetX,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    val animatedTextOffsetY by animateDpAsState(
        targetValue = textOffsetY,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    val animatedButtonOffsetY by animateDpAsState(
        targetValue = buttonOffsetY,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.offset(x = animatedFirstCircleOffsetX)) {
                drawCircle(
                    color = SecondaryColor,
                    radius = 50.dp.toPx()
                )
            }

            Canvas(modifier = Modifier.offset(x = animatedSecondCircleOffsetX)) {
                drawCircle(
                    color = ModeratelyBlue,
                    radius = 50.dp.toPx()
                )
            }
        }

        MulticoloredText(
            offset = animatedTextOffsetY
        )

        NextButton(
            onClick = { navController.navigate(RouteNavigate.ONBOARDING) },
            offset = animatedButtonOffsetY,
            text = R.string.get_started
        )
    }
}



