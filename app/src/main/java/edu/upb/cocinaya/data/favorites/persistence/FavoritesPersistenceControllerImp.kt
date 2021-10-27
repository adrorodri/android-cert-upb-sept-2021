package edu.upb.cocinaya.data.favorites.persistence

import edu.upb.cocinaya.App
import edu.upb.cocinaya.model.Favorite
import kotlinx.coroutines.flow.Flow

class FavoritesPersistenceControllerImp: FavoritesPersistenceController {
    private val db = App.db

    override fun getFavoritesByPostId(postId: Int): Flow<Favorite> {
        return db.favoritesDao().getFavoriteByPostId(postId)
    }

    override fun getFavorites(): List<Favorite> {
        return db.favoritesDao().getAllFavorites()
    }

    override fun saveFavorite(favorite: Favorite) {
        db.favoritesDao().saveToFavorites(favorite)
    }

    override fun deleteFavorite(favorite: Favorite) {
        db.favoritesDao().deleteFavorite(favorite)
    }
}