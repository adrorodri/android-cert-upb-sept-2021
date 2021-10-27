package edu.upb.cocinaya.data.favorites.persistence

import edu.upb.cocinaya.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoritesPersistenceController {
    fun getFavoritesByPostId(postId: Int): Flow<Favorite>
    fun getFavorites(): List<Favorite>
    fun saveFavorite(favorite: Favorite)
    fun deleteFavorite(favorite: Favorite)
}