package edu.upb.cocinaya.data.feed.persistency

import edu.upb.cocinaya.model.Post

interface FeedPersistencyController {
    fun getAllPosts(): List<Post>
    fun savePosts(posts: List<Post>)
    fun searchPosts(query: String): List<Post>
}