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
import edu.upb.cocinaya.model.Favorite
import edu.upb.cocinaya.model.Post
import java.util.*

class PostDetailsFragment: Fragment() {

    private lateinit var post: Post
    private val args: PostDetailsFragmentArgs by navArgs()
    private val postDetailsViewModel: PostDetailsViewModel by viewModels()
    var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ivPostImage = view.findViewById<ImageView>(R.id.ivPostImage)
        val tvPostPublisher = view.findViewById<TextView>(R.id.tvPostPublisher)
        val tvPostShortDescription = view.findViewById<TextView>(R.id.tvPostShortDescription)
        val tvPostTime = view.findViewById<TextView>(R.id.tvPostTime)
        val tvPostLikes = view.findViewById<TextView>(R.id.tvPostLikes)
        val btFavorite = view.findViewById<Button>(R.id.btFavorite)

        post = args.post

        Glide.with(view)
            .load(post.imageUrl)
            .transform(CenterCrop(), RoundedCorners(24))
            .into(ivPostImage)
        tvPostPublisher.text = post.publisher
        tvPostShortDescription.text = post.shortDescription
        tvPostTime.text = "${post.time} min"
        tvPostLikes.text = "${post.likes}"

        postDetailsViewModel.favorite.observe(viewLifecycleOwner) {
            isFavorite = it != null
            if (isFavorite) {
                btFavorite.text = "ES FAVORITO"
            } else {
                btFavorite.text = "NO ES FAVORITO"
            }
        }
        postDetailsViewModel.getFavoriteForPostId(post.id)

        btFavorite.setOnClickListener {
            if(isFavorite) {
                postDetailsViewModel.deleteFavorite(postDetailsViewModel.favorite.value!!)
            } else {
                postDetailsViewModel.saveFavorite(Favorite(1, post.id, System.currentTimeMillis().toString()))
            }
        }
    }
}