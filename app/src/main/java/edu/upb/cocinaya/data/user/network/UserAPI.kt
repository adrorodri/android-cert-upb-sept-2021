package edu.upb.cocinaya.data.user.network

import edu.upb.cocinaya.data.user.model.LoginRequest
import edu.upb.cocinaya.data.user.model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @POST("/register")
    suspend fun register(@Body loginRequest: RegisterRequest)
}