package com.example.epiceats.domain.repo

import com.example.epiceats.common.ResultState
import com.example.epiceats.data.models.AuthRequest
import com.example.epiceats.data.models.TokenPair
import kotlinx.coroutines.flow.Flow

interface Repo {

    fun loginWithEmailAndPassword(userData: AuthRequest) : Flow<ResultState<TokenPair>>
    fun registerWithEmailAndPassword(userData: AuthRequest) : Flow<ResultState<TokenPair>>
}