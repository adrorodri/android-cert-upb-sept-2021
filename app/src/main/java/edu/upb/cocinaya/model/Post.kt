package edu.upb.cocinaya.model

import java.io.Serializable

data class Post(val publisher: String,
                val shortDescription: String,
                val longDescription: String,
                val imageUrl: String,
                val time: Long,
                val likes: Int): Serializable
