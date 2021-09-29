package edu.upb.cocinaya.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import edu.upb.cocinaya.R

class LoginOptionsFragment: Fragment() {

    private var actionCompleteListener: OnActionCompleteListener? = null

    private lateinit var btSignUpEmail: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fagment_login_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btSignUpEmail = view.findViewById(R.id.btSignUpEmail)

        btSignUpEmail.setOnClickListener {
            actionCompleteListener?.success()
        }
    }

    fun setOnActionCompleteListener(actionListener: OnActionCompleteListener) {
        actionCompleteListener = actionListener
    }
}