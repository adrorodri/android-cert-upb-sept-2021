package edu.upb.cocinaya.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.model.User

class ProfileViewModel: ViewModel() {
    val user = MutableLiveData<User>()
    val editModeEnabled = MutableLiveData(false)
}