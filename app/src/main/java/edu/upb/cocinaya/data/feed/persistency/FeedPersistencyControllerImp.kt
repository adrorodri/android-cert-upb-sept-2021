package edu.upb.cocinaya.data.feed.persistency

import edu.upb.cocinaya.model.Post

class FeedPersistencyControllerImp: FeedPersistencyController {
    private var postList: List<Post> = listOf()

    override fun getAllPosts(): List<Post> {
        return postList
    }

    override fun savePosts(posts: List<Post>) {
        postList = posts
    }

    override fun searchPosts(query: String): List<Post> {
        return postList.filter {
            it.shortDescription.toLowerCase().contains(query.toLowerCase())
        }
    }

}