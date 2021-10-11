package edu.upb.cocinaya.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import edu.upb.cocinaya.R
import edu.upb.cocinaya.databinding.ListItemFeedBinding
import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.ui.interfaces.OnFeedItemClickListener

class FeedListAdapter: RecyclerView.Adapter<FeedListViewHolder>() {
    private val elementList: MutableList<Post> = mutableListOf()
    private var onFeedItemClickListener: ((post: Post) -> Unit)? = null

    private lateinit var asd: View

    fun addAll(newElementList: MutableList<Post>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnFeedItemClickListener(onFeedItemClickListener: ((post: Post) -> Unit)?) {
        this.onFeedItemClickListener = onFeedItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedListViewHolder {
        val binding = ListItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedListViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.binding.root.setOnClickListener {
            onFeedItemClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class FeedListViewHolder(val binding: ListItemFeedBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        Glide.with(itemView)
            .load(post.imageUrl)
            .transform(CenterCrop(),RoundedCorners(24))
            .into(binding.ivPostImage)
        binding.tvPostPublisher.text = post.publisher
        binding.tvPostShortDescription.text = post.shortDescription
        binding.tvPostTime.text = "${post.time} min"
        binding.tvPostLikes.text = "${post.likes}"
    }
}