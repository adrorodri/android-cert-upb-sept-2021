package edu.upb.cocinaya.data

import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.model.User

object PostDataSource {
    private var postList = mutableListOf(
        Post(
            publisher = "Andre Machicado",
            shortDescription = "Enchiladas Suizas en Microondas!",
            imageUrl = "https://cdn7.kiwilimon.com/recetaimagen/26245/th5-320x213-38984.jpg",
            time = 900,
            likes = 256
        ),
        Post(
            publisher = "Joel Jarro",
            shortDescription = "Carne a la parrilla, sin parrilla?",
            imageUrl = "https://cocina-casera.com/wp-content/uploads/2018/01/Carne-a-la-parilla.jpg",
            time = 2700,
            likes = 128
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 7200,
            likes = 1000
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 7200,
            likes = 1000
        ),
        Post(
            publisher = "Roberto Cuevas",
            shortDescription = "Chicharron de Cerdo",
            imageUrl = "https://www.cocina-ecuatoriana.com/base/stock/Recipe/299-image/299-image_web.jpg",
            time = 7200,
            likes = 1000
        )
    )

    fun getPostList(): List<Post> {
        return postList
    }

    fun setPostList(postList: List<Post>) {
        this.postList = postList.toMutableList()
    }

    fun searchPosts(query: String): List<Post> {
        return postList.filter {
            it.shortDescription.toLowerCase().contains(query.toLowerCase())
        }
    }
}