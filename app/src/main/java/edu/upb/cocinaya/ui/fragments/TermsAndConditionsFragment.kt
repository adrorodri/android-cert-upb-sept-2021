package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.upb.cocinaya.R
import edu.upb.cocinaya.ui.base.StepsBaseFragment

class TermsAndConditionsFragment: StepsBaseFragment() {

    lateinit var btAccept: View
    lateinit var btDecline: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btAccept = view.findViewById(R.id.btAccept)
        btDecline = view.findViewById(R.id.btDecline)

        btAccept.setOnClickListener {
            val goToMainMenuDirections = TermsAndConditionsFragmentDirections.actionGoToMainMenuActivity()
            findNavController().navigate(goToMainMenuDirections)
            activity?.finish()
        }
        btDecline.setOnClickListener {
            val goToErrorDirections = TermsAndConditionsFragmentDirections.actionGoToError()
            findNavController().navigate(goToErrorDirections)
        }
    }
}