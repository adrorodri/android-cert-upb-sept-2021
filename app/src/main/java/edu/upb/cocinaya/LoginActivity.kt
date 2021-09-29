package edu.upb.cocinaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import edu.upb.cocinaya.ui.LoginOptionsFragment
import edu.upb.cocinaya.ui.OnActionCompleteListener
import edu.upb.cocinaya.ui.TermsAndConditionsFragment

class LoginActivity : AppCompatActivity() {

    val loginFragment = LoginOptionsFragment()
    val termsAndConditionsFragment = TermsAndConditionsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        replaceWithFragment(loginFragment)

        loginFragment.setOnActionCompleteListener(object: OnActionCompleteListener {
            override fun success() {
                goToNextFragment(termsAndConditionsFragment)
            }

            override fun error() {

            }
        })
    }

    fun replaceWithFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerLoginOptions, fragment)
        ft.commit()
    }

    fun goToNextFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.containerLoginOptions, fragment)
        ft.addToBackStack("Test")
        ft.commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1) {
            supportFragmentManager.popBackStack()
            return
        }
        super.onBackPressed()
    }
}