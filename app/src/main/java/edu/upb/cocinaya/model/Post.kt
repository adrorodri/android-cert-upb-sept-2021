package edu.upb.cocinaya.model

data class Post(val publisher: String,
                val shortDescription: String,
                val imageUrl: String,
                val time: Long,
                val likes: Int)
