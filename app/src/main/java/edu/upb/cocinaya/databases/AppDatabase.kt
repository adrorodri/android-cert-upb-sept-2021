package edu.upb.cocinaya.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.upb.cocinaya.databases.daos.PostsDao
import edu.upb.cocinaya.model.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun postsDao(): PostsDao
}