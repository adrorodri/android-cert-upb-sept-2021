package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import edu.upb.cocinaya.R
import edu.upb.cocinaya.databinding.FragmentPostDetailsBinding
import edu.upb.cocinaya.model.Favorite
import edu.upb.cocinaya.model.Post
import java.util.*

class PostDetailsFragment: Fragment() {

    private lateinit var post: Post
    private lateinit var binding: FragmentPostDetailsBinding
    private val args: PostDetailsFragmentArgs by navArgs()
    private val postDetailsViewModel: PostDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        post = args.post

        Glide.with(view)
            .load(post.imageUrl)
            .transform(CenterCrop(), RoundedCorners(24))
            .into(binding.ivPostImage)
        binding.tvPostPublisher.text = post.publisher
        binding.tvPostShortDescription.text = post.shortDescription
        binding.tvPostTime.text = "${post.time} min"
        binding.tvPostLikes.text = "${post.likes}"

        postDetailsViewModel.favorite.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.btFavorite.text = "ES FAVORITO"
            } else {
                binding.btFavorite.text = "NO ES FAVORITO"
            }
        }
        postDetailsViewModel.getFavoriteForPostId(post.id)

        binding.btFavorite.setOnClickListener {
            if(postDetailsViewModel.favorite.value != null) {
                postDetailsViewModel.deleteFavorite(postDetailsViewModel.favorite.value!!)
            } else {
                postDetailsViewModel.saveFavorite(Favorite(0, post.id, System.currentTimeMillis().toString()))
            }
        }
    }
}