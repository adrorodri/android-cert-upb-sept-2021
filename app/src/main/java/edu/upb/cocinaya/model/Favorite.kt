package edu.upb.cocinaya.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(@PrimaryKey(autoGenerate = true) val id: Int,
                    val postId: Int,
                    val date: String)