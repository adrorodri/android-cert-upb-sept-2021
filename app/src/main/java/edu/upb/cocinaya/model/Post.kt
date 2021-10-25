package edu.upb.cocinaya.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Post(@PrimaryKey val id: Int,
                val publisher: String,
                val shortDescription: String,
                val imageUrl: String,
                val time: Long,
                val likes: Int): Serializable
