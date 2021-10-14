package edu.upb.cocinaya.ui.mainmenu.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.UserDataSource

class UserViewModel: ViewModel() {
    val user = MutableLiveData(UserDataSource.getUser())

    fun updateUser() {
        user.postValue(user.value)
        UserDataSource.setUser(user.value)
    }
}