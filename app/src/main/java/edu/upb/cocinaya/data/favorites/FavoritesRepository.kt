package edu.upb.cocinaya.data.favorites

import edu.upb.cocinaya.data.favorites.persistence.FavoritesPersistenceController
import edu.upb.cocinaya.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoritesRepository(private val persistence: FavoritesPersistenceController) {
    fun getFavoritesForPostId(postId: Int): Flow<Favorite> {
        return persistence.getFavoritesByPostId(postId)
    }

    fun getFavorites(): List<Favorite> {
        return persistence.getFavorites()
    }

    fun saveFavorite(favorite: Favorite): Flow<Any> {
        return flow {
            persistence.saveFavorite(favorite)
        }
    }

    fun deleteFavorite(favorite: Favorite): Flow<Any> {
        return flow {
            persistence.deleteFavorite(favorite)
        }
    }
}