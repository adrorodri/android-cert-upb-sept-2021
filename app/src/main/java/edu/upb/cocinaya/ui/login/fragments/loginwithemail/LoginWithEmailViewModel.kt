package edu.upb.cocinaya.ui.login.fragments.loginwithemail

import androidx.lifecycle.ViewModel
import edu.upb.cocinaya.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent.inject

class LoginWithEmailViewModel: ViewModel() {
    private val userRepository by inject(UserRepository::class.java)

    fun login(username: String, password: String): Job {
        return userRepository.login(username, password).launchIn(CoroutineScope(Dispatchers.Main))
    }
}