package edu.upb.cocinaya.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.upb.cocinaya.R
import edu.upb.cocinaya.replaceFragment
import edu.upb.cocinaya.ui.fragments.ChatFragment
import edu.upb.cocinaya.ui.fragments.FeedFragment
import edu.upb.cocinaya.ui.fragments.ProfileFragment

class MainMenuActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val profileFragment = ProfileFragment()
    private val feedFragment = FeedFragment()
    private val chatFragment = ChatFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)





//        bottomNavigationView.setOnItemSelectedListener {
//            when(it.itemId) {
//                R.id.menuItemProfile -> {
//                    replaceFragment(R.id.container, profileFragment)
//                }
//                R.id.menuItemFeed -> {
//                    replaceFragment(R.id.container, feedFragment)
//                }
//                R.id.menuItemChat -> {
//                    replaceFragment(R.id.container, chatFragment)
//                }
//            }
//            true
//        }
//
//        bottomNavigationView.selectedItemId = R.id.menuItemFeed
    }
}