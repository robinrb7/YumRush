package com.example.epiceats.domain.repo

import com.example.epiceats.common.ResultState
import com.example.epiceats.data.models.UserData
import kotlinx.coroutines.flow.Flow

interface Repo {

    fun loginWithEmailAndPassword(userData: UserData) : Flow<ResultState<String>>
    fun registerWithEmailAndPassword(userData: UserData) : Flow<ResultState<String>>
}