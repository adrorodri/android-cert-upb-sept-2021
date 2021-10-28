package edu.upb.cocinaya.ui.login.fragments.loginoptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.upb.cocinaya.databinding.FragmentLoginOptionsBinding
import edu.upb.cocinaya.ui.base.StepsBaseFragment

class LoginOptionsFragment: StepsBaseFragment() {
    private lateinit var binding: FragmentLoginOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btSignUpEmail.setOnClickListener {
            val goToTermsAndConditionsDirections = LoginOptionsFragmentDirections.actionGoToLoginWithEmail()
            findNavController().navigate(goToTermsAndConditionsDirections)
        }
    }
}