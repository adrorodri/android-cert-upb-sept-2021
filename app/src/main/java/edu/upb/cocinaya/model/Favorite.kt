package edu.upb.cocinaya.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(@PrimaryKey val id: Int,
                    val postId: Int,
                    val date: String)