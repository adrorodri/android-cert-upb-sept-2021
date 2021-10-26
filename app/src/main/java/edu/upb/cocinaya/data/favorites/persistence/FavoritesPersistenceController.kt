package edu.upb.cocinaya.data.favorites.persistence

import edu.upb.cocinaya.model.Favorite

interface FavoritesPersistenceController {
    fun getFavoritesByPostId(postId: Int): Favorite
    fun getFavorites(): List<Favorite>
    fun saveFavorite(favorite: Favorite)
    fun deleteFavorite(favorite: Favorite)
}