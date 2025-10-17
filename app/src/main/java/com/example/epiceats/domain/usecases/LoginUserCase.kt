package com.example.epiceats.domain.usecases

import com.example.epiceats.common.ResultState
import com.example.epiceats.data.models.UserData
import com.example.epiceats.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserCase @Inject constructor(val repo: Repo) {

    fun loginUser(userData: UserData): Flow<ResultState<String>>{
        return repo.loginWithEmailAndPassword(userData)
    }
}