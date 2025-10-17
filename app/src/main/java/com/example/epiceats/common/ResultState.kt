package com.example.epiceats.common

sealed class ResultState<out T> {
    data class Success<T>(val data: T): ResultState<T>()
    data class Error(val mssg: String): ResultState<Nothing>()
    object Loading: ResultState<Nothing>()
}