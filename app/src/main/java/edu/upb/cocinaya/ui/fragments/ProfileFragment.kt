package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import edu.upb.cocinaya.databinding.FragmentProfileBinding
import edu.upb.cocinaya.model.User
import edu.upb.cocinaya.ui.viewmodels.ProfileViewModel

class ProfileFragment: Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            val newUser = User("username", "Chewbacca", "", "https://static.wikia.nocookie.net/starwars/images/4/48/Chewbacca_TLJ.png/revision/latest/top-crop/width/360/height/360?cb=20210106001220")
            profileViewModel.user.postValue(newUser)
        }, 2000)

        binding.ivEdit.setOnClickListener {
            profileViewModel.editModeEnabled.postValue(!profileViewModel.editModeEnabled.value!!)
        }
    }
}