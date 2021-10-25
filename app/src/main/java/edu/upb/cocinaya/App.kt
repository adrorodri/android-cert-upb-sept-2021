package edu.upb.cocinaya

import android.app.Application
import androidx.room.Room
import edu.upb.cocinaya.databases.AppDatabase

class App: Application() {
    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()
    }
}