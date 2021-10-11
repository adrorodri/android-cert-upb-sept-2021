package edu.upb.cocinaya.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.upb.cocinaya.R
import edu.upb.cocinaya.databinding.ActivityMainMenuBinding
import edu.upb.cocinaya.replaceFragment
import edu.upb.cocinaya.ui.fragments.ChatFragment
import edu.upb.cocinaya.ui.fragments.FeedFragment
import edu.upb.cocinaya.ui.fragments.ProfileFragment

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }
}