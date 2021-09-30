package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import edu.upb.cocinaya.R
import edu.upb.cocinaya.ui.base.StepsBaseFragment

class LoginOptionsFragment: StepsBaseFragment() {

    private lateinit var btSignUpEmail: View

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
            onSuccess?.invoke()
        }
    }
}