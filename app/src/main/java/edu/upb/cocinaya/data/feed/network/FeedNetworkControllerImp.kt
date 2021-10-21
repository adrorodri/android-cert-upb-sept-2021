package edu.upb.cocinaya.data.feed.network

import edu.upb.cocinaya.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class FeedNetworkControllerImp: FeedNetworkController {
    val client = Retrofit.Builder()
        .baseUrl("http://10.100.1.16:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FeedAPI::class.java)

    override suspend fun getAllPosts(): List<Post> {
        return client.getAllPosts()
    }
}