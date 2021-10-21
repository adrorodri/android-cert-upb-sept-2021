package edu.upb.cocinaya.data.feed.network

import edu.upb.cocinaya.model.Post

interface FeedNetworkController {
    suspend fun getAllPosts(): List<Post>
}