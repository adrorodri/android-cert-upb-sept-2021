package edu.upb.cocinaya.ui.mainmenu.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.TempDataSource

class UserViewModel: ViewModel() {
    val user = MutableLiveData(TempDataSource.getUser())

    fun updateUser() {
        user.postValue(user.value)
        TempDataSource.setUser(user.value)
    }
}