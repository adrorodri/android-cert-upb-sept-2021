package edu.upb.cocinaya.data.user.network

import edu.upb.cocinaya.data.user.model.LoginRequest
import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest)
}