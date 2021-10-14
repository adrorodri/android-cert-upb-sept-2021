package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.PostDataSource
import edu.upb.cocinaya.data.UserDataSource

class FeedViewModel: ViewModel() {
    val filteredPosts = MutableLiveData(PostDataSource.getPostList())

    fun searchPosts(query: String) {
        if(query.isNotBlank()) {
            filteredPosts.postValue(PostDataSource.searchPosts(query))
        } else {
            filteredPosts.postValue(PostDataSource.getPostList())
        }
    }
}