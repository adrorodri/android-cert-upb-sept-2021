package edu.upb.cocinaya.ui.login.fragments.loginoptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import edu.upb.cocinaya.databinding.FragmentLoginOptionsBinding
import edu.upb.cocinaya.databinding.FragmentLoginWithEmailBinding
import edu.upb.cocinaya.ui.base.StepsBaseFragment
import edu.upb.cocinaya.ui.login.fragments.loginwithemail.LoginWithEmailViewModel
import edu.upb.cocinaya.ui.login.fragments.termsAndConditions.TermsAndConditionsFragmentDirections
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginWithEmailFragment : StepsBaseFragment() {
    private lateinit var binding: FragmentLoginWithEmailBinding
    private val loginWithEmailViewModel: LoginWithEmailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginWithEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btLogin.setOnClickListener {
            val username = binding.editTextEmailAddress.text.toString()
            val password = binding.editTextPassword.text.toString()

            loginWithEmailViewModel.login(username, password).invokeOnCompletion {
                val goToTermsAndConditionsDirections =
                    LoginWithEmailFragmentDirections.actionGoToTermsAndConditions()
                findNavController().navigate(goToTermsAndConditionsDirections)
            }
        }
    }
}