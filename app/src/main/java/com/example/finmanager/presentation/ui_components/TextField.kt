package com.example.finmanager.presentation.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun LoginTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = placeholder,
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isError) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }
        }
    )
}