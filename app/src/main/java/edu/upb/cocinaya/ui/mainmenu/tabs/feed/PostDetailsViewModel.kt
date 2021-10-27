package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.cocinaya.data.favorites.FavoritesRepository
import edu.upb.cocinaya.data.favorites.persistence.FavoritesPersistenceControllerImp
import edu.upb.cocinaya.data.feed.FeedRepository
import edu.upb.cocinaya.data.feed.network.FeedNetworkControllerImp
import edu.upb.cocinaya.data.feed.persistency.FeedPersistencyControllerImp
import edu.upb.cocinaya.model.Favorite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject

class PostDetailsViewModel : ViewModel() {
    private val favoritesRepository by inject(FavoritesRepository::class.java)
    val favorite = MutableLiveData<Favorite?>()

    fun getFavoriteForPostId(postId: Int) {
        favoritesRepository.getFavoritesForPostId(postId).onEach {
            favorite.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun getAllFavorites(): List<Favorite> {
        return favoritesRepository.getFavorites()
    }

    fun saveFavorite(favorite: Favorite) {
        favoritesRepository.saveFavorite(favorite).launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun deleteFavorite(favorite: Favorite) {
        favoritesRepository.deleteFavorite(favorite).launchIn(CoroutineScope(Dispatchers.IO))
    }
}