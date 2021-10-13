package edu.upb.cocinaya.ui.mainmenu.tabs.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.TempDataSource
import edu.upb.cocinaya.model.User

class ProfileViewModel: ViewModel() {
    val editModeEnabled = MutableLiveData(false)
}