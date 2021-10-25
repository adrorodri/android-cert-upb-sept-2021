package edu.upb.cocinaya.data.feed.persistency

import edu.upb.cocinaya.App
import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow

class FeedPersistencyControllerImp: FeedPersistencyController {
    private val db = App.db

    override fun getAllPosts(): Flow<List<Post>> {
        return db.postsDao().getAllPosts()
    }

    override fun savePosts(posts: List<Post>) {
        db.postsDao().saveAllPosts(posts)
    }

    override fun searchPosts(query: String): List<Post> {
        return db.postsDao().searchPosts(query)
    }

}