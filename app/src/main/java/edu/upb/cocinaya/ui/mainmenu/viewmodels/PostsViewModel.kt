package edu.upb.cocinaya.ui.mainmenu.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.PostDataSource
import edu.upb.cocinaya.data.UserDataSource

class PostsViewModel: ViewModel() {
    val posts = MutableLiveData(PostDataSource.getPostList())
}