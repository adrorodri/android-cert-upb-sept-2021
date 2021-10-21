package edu.upb.cocinaya.data.feed.network

import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedAPI {
    @GET("/posts")
    suspend fun getAllPosts(): List<Post>

    @POST("/posts/1928398")
    suspend fun addNewPost(): List<Post>
}