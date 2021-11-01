package edu.upb.cocinaya.data.user.network

import edu.upb.cocinaya.data.user.model.LoginRequest
import edu.upb.cocinaya.data.user.model.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp: UserNetworkController {
    val client = Retrofit.Builder()
        .baseUrl("http://10.100.1.7:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    override suspend fun login(username: String, password: String) {
        return client.login(LoginRequest(username, password))
    }

    override suspend fun register(username: String, password: String) {
        return client.register(RegisterRequest(username, password))
    }
}