package edu.upb.cocinaya.data.feed.persistency

import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow

interface FeedPersistencyController {
    fun getAllPosts(): Flow<List<Post>>
    fun savePosts(posts: List<Post>)
    fun searchPosts(query: String): List<Post>
}