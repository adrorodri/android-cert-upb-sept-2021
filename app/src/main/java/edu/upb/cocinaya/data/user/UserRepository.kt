package edu.upb.cocinaya.data.user

import edu.upb.cocinaya.data.user.network.UserNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(val network: UserNetworkController) {
    fun login(username: String, password: String): Flow<Any> {
        return flow {
            network.login(username, password)
        }
    }
}