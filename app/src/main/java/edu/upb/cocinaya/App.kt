package edu.upb.cocinaya

import android.app.Application
import androidx.room.Room
import edu.upb.cocinaya.data.favorites.FavoritesRepository
import edu.upb.cocinaya.data.favorites.persistence.FavoritesPersistenceController
import edu.upb.cocinaya.data.favorites.persistence.FavoritesPersistenceControllerImp
import edu.upb.cocinaya.data.user.UserRepository
import edu.upb.cocinaya.data.user.network.UserNetworkController
import edu.upb.cocinaya.data.user.network.UserNetworkControllerImp
import edu.upb.cocinaya.databases.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    companion object {
        lateinit var db: AppDatabase
    }

    val appModule = module {
        single<FavoritesPersistenceController> { FavoritesPersistenceControllerImp() }
        single { FavoritesRepository(get()) }

        single<UserNetworkController> { UserNetworkControllerImp() }
        single { UserRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}