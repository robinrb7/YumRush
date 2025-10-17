package com.example.epiceats.retrofit

import com.example.epiceats.data.models.AuthRequest
import com.example.epiceats.data.models.RefreshRequest
import com.example.epiceats.data.models.TokenPair
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {
    @POST("auth/register")
    suspend fun register(@Body request: AuthRequest): Response<TokenPair>

    @POST("auth/login")
    suspend fun login(@Body request: AuthRequest): Response<TokenPair>

    @POST("auth/refresh")
    suspend fun refresh(@Body request: RefreshRequest): Response<TokenPair>
}