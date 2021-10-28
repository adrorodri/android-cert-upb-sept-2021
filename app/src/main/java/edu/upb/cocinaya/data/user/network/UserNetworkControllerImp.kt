package edu.upb.cocinaya.data.user.network

import edu.upb.cocinaya.data.feed.network.FeedAPI
import edu.upb.cocinaya.data.user.model.LoginRequest
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
}