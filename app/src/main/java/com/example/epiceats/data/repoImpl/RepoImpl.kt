package com.example.epiceats.data.repoImpl


import com.example.epiceats.common.ResultState

import com.example.epiceats.data.models.AuthRequest
import com.example.epiceats.data.models.TokenPair

import com.example.epiceats.domain.repo.Repo
import com.example.epiceats.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepoImpl @Inject constructor(): Repo {
    private val api = RetrofitInstance.getApiService()

    override fun registerWithEmailAndPassword(userData: AuthRequest): Flow<ResultState<TokenPair>>
    = flow{
        emit(ResultState.Loading)

        try{
            val response = api.register(userData)
            if(response.isSuccessful){
                response.body()?.let{ emit(ResultState.Success(it)) }
                    ?: emit(ResultState.Error("Empty Response"))

            }  else{
                emit(ResultState.Error(response.errorBody()?.string() ?: "Registration Failed"))
            }
        }  catch (e: IOException) {
            emit(ResultState.Error("Network Error: ${e.localizedMessage}"))
        } catch (e: HttpException) {
            emit(ResultState.Error("HTTP Error: ${e.localizedMessage}"))
        }

    }

    override fun loginWithEmailAndPassword(userData: AuthRequest): Flow<ResultState<TokenPair>> =
        flow{

            try {
                val response = api.login(userData)
                if (response.isSuccessful) {
                    response.body()?.let { emit(ResultState.Success(it)) }
                        ?: emit(ResultState.Error("Empty response"))
                } else {
                    emit(ResultState.Error(response.errorBody()?.string() ?: "Login failed"))
                }
            } catch (e: IOException) {
                emit(ResultState.Error("Network Error: ${e.localizedMessage}"))
            } catch (e: HttpException) {
                emit(ResultState.Error("HTTP Error: ${e.localizedMessage}"))
            }
        }

    }