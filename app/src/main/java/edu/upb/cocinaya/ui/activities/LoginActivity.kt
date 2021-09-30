package edu.upb.cocinaya.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.upb.cocinaya.R
import edu.upb.cocinaya.addFragmentToStack
import edu.upb.cocinaya.replaceFragment
import edu.upb.cocinaya.ui.fragments.LoginOptionsFragment
import edu.upb.cocinaya.ui.fragments.TermsAndConditionsFragment

class LoginActivity : AppCompatActivity() {

    val loginFragment = LoginOptionsFragment()
    val termsAndConditionsFragment = TermsAndConditionsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        replaceFragment(R.id.containerLoginOptions, loginFragment)

        loginFragment.setOnSuccessListener {
            addFragmentToStack(R.id.containerLoginOptions, termsAndConditionsFragment)
        }
        loginFragment.setOnErrorListener {
            Toast.makeText(this, "ERROR ${it}", Toast.LENGTH_SHORT).show()
        }

        termsAndConditionsFragment.setOnSuccessListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
        termsAndConditionsFragment.setOnErrorListener {
            Toast.makeText(this, "ERROR ${it}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1) {
            supportFragmentManager.popBackStack()
            return
        }
        super.onBackPressed()
    }
}