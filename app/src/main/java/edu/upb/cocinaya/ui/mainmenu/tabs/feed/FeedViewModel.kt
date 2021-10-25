package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.cocinaya.data.feed.FeedRepository
import edu.upb.cocinaya.data.feed.network.FeedNetworkControllerImp
import edu.upb.cocinaya.data.feed.persistency.FeedPersistencyControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class FeedViewModel : ViewModel() {
    private val feedRepository =
        FeedRepository(FeedNetworkControllerImp(), FeedPersistencyControllerImp())

    val posts = feedRepository.getAllPostList().asLiveData(Dispatchers.IO)

    fun searchPosts(query: String) {
        if (query.isNotBlank()) {
            feedRepository.searchPosts(query)
        } else {
            feedRepository.searchPosts("")
        }
    }

    fun updateFeed(): Job {
        return feedRepository.updatePosts().launchIn(CoroutineScope(Dispatchers.IO))
    }
}