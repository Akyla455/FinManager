package com.example.finmanager.presentation.screens.authorization

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finmanager.R
import com.example.finmanager.presentation.navigation.RouteNavigate
import com.example.finmanager.presentation.screens.AuthViewModel
import com.example.finmanager.presentation.ui_components.BoltText
import com.example.finmanager.presentation.ui_components.DualCircles
import com.example.finmanager.presentation.ui_components.LoginTextField
import com.example.finmanager.presentation.ui_components.NextButton
import com.example.finmanager.presentation.ui_components.PasswordTextField
import com.example.finmanager.presentation.ui_components.SmallTransparentText

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavController
){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var emailError by remember {
        mutableStateOf(false)
    }
    var passwordError by remember{
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .padding(
                start = 33.dp,
                end = 33.dp,
                top = 54.dp
            )
            .fillMaxSize()
    ) {
        DualCircles()
        BoltText(
            modifier = modifier.padding(top = 27.dp),
            text = R.string.registration
        )
        SmallTransparentText(
            modifier = modifier.padding(top = 50.dp),
            text = R.string.email
        )

        LoginTextField(
            modifier = modifier.fillMaxWidth(),
            value = email ,
            onValueChange ={
                email = it
            },
            placeholder = {
                SmallTransparentText(text = R.string.hilt_email)
            },
            isError = emailError
        )

        SmallTransparentText(
            modifier = modifier.padding(top = 25.dp),
            text =R.string.password
        )


        PasswordTextField(
            modifier = modifier.fillMaxWidth(),
            value = password ,
            onValueChange = {
                password = it
            },
            isError = passwordError
        )
        
        NextButton(
            modifier = modifier
                .padding(top = 50.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                emailError = email.isBlank()
                passwordError = password.isBlank()
                if(!emailError && !passwordError){
                    authViewModel
                        .onRegisterChanged(
                            newLogin = email,
                            newPassword = password)
                    navController.navigate(RouteNavigate.PROFILE)
                }

                      },
            text = R.string.registration
        )

        Divider(
            modifier = modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp
        )
        Row(
            modifier = modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SmallTransparentText(
                text = R.string.have_an_account
            )
            SmallTransparentText(
                text = R.string.enter,
                color = Color.Blue,
                onClick = {
                    navController.navigate(RouteNavigate.AUTHORIZATION)
                }
            )
        }
    }
}
