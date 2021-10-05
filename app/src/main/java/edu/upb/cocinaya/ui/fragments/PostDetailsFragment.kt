package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import edu.upb.cocinaya.R
import edu.upb.cocinaya.model.Post

class PostDetailsFragment: Fragment() {

    var post: Post? = null

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

        post = arguments?.getSerializable("post") as Post?
        post?.let{
            Glide.with(view)
                .load(it.imageUrl)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(ivPostImage)
            tvPostPublisher.text = it.publisher
            tvPostShortDescription.text = it.shortDescription
            tvPostTime.text = "${it.time} min"
            tvPostLikes.text = "${it.likes}"
        }
    }
}