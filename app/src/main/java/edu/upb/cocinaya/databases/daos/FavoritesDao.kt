package edu.upb.cocinaya.databases.daos

import androidx.room.*
import edu.upb.cocinaya.model.Favorite
import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorite WHERE postId = :postId")
    fun getFavoriteByPostId(postId: Int): Flow<Favorite>

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): List<Favorite>

    @Insert
    fun saveToFavorites(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)
}