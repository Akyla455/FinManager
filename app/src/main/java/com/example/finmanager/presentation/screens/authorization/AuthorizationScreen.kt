package com.example.finmanager.presentation.screens.authorization

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finmanager.R
import com.example.finmanager.presentation.navigation.RouteNavigate
import com.example.finmanager.presentation.screens.AuthViewModel
import com.example.finmanager.presentation.ui_components.BoltText
import com.example.finmanager.presentation.ui_components.DualCircles
import com.example.finmanager.presentation.ui_components.NextButton
import com.example.finmanager.presentation.ui_components.SmallTransparentText

@Composable
fun AuthorizationScreen(
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

    var isPasswordVisible by remember {
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

        TextField(
            modifier = modifier.fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = { SmallTransparentText(text = R.string.hilt_email) },
            isError = emailError,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent
            )
        )
        SmallTransparentText(
            modifier = modifier.padding(top = 25.dp),
            text =R.string.password
        )

        TextField(
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = passwordError,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                        contentDescription = null
                    )
                }
            }
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
    }
}
//@Preview
//@Composable
//fun Preview(){
//    AuthorizationScreen()
//}