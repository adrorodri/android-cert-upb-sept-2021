package edu.upb.cocinaya.model

import androidx.databinding.ObservableField
import java.io.Serializable

class User(val username: String, var firstName: String, var lastName: String, val profilePictureUrl: String) : Serializable {
//    var username = ObservableField<String>()
//    var firstName = ObservableField<String?>()
//    var lastName = ObservableField<String?>()
//    var profilePictureUrl = ObservableField<String>()
//
//    init {
//        this.username.set(username)
//        this.firstName.set(firstName)
//        this.lastName.set(lastName)
//        this.profilePictureUrl.set(profilePictureUrl)
//    }
}
