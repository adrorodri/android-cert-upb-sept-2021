package edu.upb.cocinaya.data

import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.model.User

object UserDataSource {
    private var user: User? = User("username", "Chewbacca", "", "https://static.wikia.nocookie.net/starwars/images/4/48/Chewbacca_TLJ.png/revision/latest/top-crop/width/360/height/360?cb=20210106001220")

    fun getUser(): User? {
        return user
    }

    fun setUser(user: User?) {
        this.user = user
    }
}