package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.upb.cocinaya.databinding.FragmentProfileBinding
import edu.upb.cocinaya.model.User

class ProfileFragment: Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.user = User("username", "Darth", "Vader")
        binding.editModeEnabled = false

        Handler(Looper.getMainLooper()).postDelayed({
            binding.user = User("username", "Chewbacca", "")
        }, 2000)

        binding.ivEdit.setOnClickListener {
            binding.editModeEnabled = true
        }
    }
}