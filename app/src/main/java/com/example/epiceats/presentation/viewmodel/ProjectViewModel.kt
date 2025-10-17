package com.example.epiceats.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epiceats.common.ResultState
import com.example.epiceats.data.models.AuthRequest
import com.example.epiceats.data.models.TokenPair
import com.example.epiceats.domain.usecases.CreateUserUseCase
import com.example.epiceats.domain.usecases.LoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserCase

): ViewModel(){
    private val _signUpScreenState = MutableStateFlow(SignUpScreenState())
    val signUpScreenState = _signUpScreenState.asStateFlow()

    private val _loginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()

    fun createUser(userData: AuthRequest){
        viewModelScope.launch{
            createUserUseCase.createUser(userData).collect {
                when(it){
                    is ResultState.Error -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(
                            isLoading = false,
                            errorMessage = it.mssg
                        )
                    }

                    ResultState.Loading -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(isLoading = true)
                    }

                    is ResultState.Success -> {
                        _signUpScreenState.value = _signUpScreenState.value.copy(
                            isLoading = false,
                            tokenPair = it.data
                        )
                    }
                }
            }
        }
    }


    fun loginUser(userData: AuthRequest){
        viewModelScope.launch{
            loginUserUseCase.loginUser(userData).collect {
                when(it){
                    is ResultState.Error -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            errorMessage = it.mssg
                        )
                    }

                    ResultState.Loading -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = true
                        )
                    }

                    is ResultState.Success -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            tokenPair = it.data
                        )
                    }
                }
            }
        }
    }




}

data class SignUpScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val tokenPair: TokenPair? = null
)

data class LoginScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val tokenPair: TokenPair? = null
)

