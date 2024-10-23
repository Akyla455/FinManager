package com.example.finmanager.domain

import javax.inject.Inject

class ValidateLoginUseCase@Inject constructor() {
    fun execute(login: String, password: String): Boolean{
        return login.isNotEmpty() && password.length >= 6
    }
}