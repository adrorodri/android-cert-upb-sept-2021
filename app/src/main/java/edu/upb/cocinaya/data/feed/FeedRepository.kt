package edu.upb.cocinaya.data.feed

import android.util.Log
import edu.upb.cocinaya.data.feed.network.FeedNetworkController
import edu.upb.cocinaya.data.feed.persistency.FeedPersistencyController
import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FeedRepository(
    private val network: FeedNetworkController,
    private val persistence: FeedPersistencyController
) {
    fun getAllPostList(): Flow<List<Post>> {
        return persistence.getAllPosts()
    }

    fun searchPosts(query: String): List<Post> {
        return persistence.searchPosts(query)
    }

    fun updatePosts(): Flow<Any> {
        return flow {
            try {
                val posts = network.getAllPosts()
                persistence.savePosts(posts)
                emit(posts)
            } catch (e: Exception) {
                Log.e("ERROR", e.message!!)
            }
        }
    }
}