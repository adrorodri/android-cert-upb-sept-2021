package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.cocinaya.data.feed.FeedRepository
import edu.upb.cocinaya.data.feed.network.FeedNetworkControllerImp
import edu.upb.cocinaya.data.feed.persistency.FeedPersistencyControllerImp
import edu.upb.cocinaya.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FeedViewModel : ViewModel() {
    val feedRepository = FeedRepository(FeedNetworkControllerImp(), FeedPersistencyControllerImp())

    val posts = feedRepository.getAllPostList().asLiveData()

//    fun getAllPosts(context: Context) {
//        feedRepository.getAllPostList(context).onEach {
//            posts.postValue(it)
//        }.launchIn(CoroutineScope(Dispatchers.IO))
//    }

    fun searchPosts(query: String) {
        if (query.isNotBlank()) {
            feedRepository.searchPosts(query)
        } else {
            feedRepository.searchPosts("")
        }
    }
}