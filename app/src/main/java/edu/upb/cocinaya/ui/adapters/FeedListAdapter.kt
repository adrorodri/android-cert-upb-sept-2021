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
import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.ui.interfaces.OnFeedItemClickListener

class FeedListAdapter: RecyclerView.Adapter<FeedListViewHolder>() {
    private val elementList: MutableList<Post> = mutableListOf()
    private var onFeedItemClickListener: ((post: Post) -> Unit)? = null

    fun addAll(newElementList: MutableList<Post>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnFeedItemClickListener(onFeedItemClickListener: ((post: Post) -> Unit)?) {
        this.onFeedItemClickListener = onFeedItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false)
        return FeedListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedListViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.itemView.setOnClickListener {
            onFeedItemClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class FeedListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val ivPostImage = itemView.findViewById<ImageView>(R.id.ivPostImage)
    private val tvPostPublisher = itemView.findViewById<TextView>(R.id.tvPostPublisher)
    private val tvPostShortDescription = itemView.findViewById<TextView>(R.id.tvPostShortDescription)
    private val tvPostTime = itemView.findViewById<TextView>(R.id.tvPostTime)
    private val tvPostLikes = itemView.findViewById<TextView>(R.id.tvPostLikes)

    fun bind(post: Post) {
        Glide.with(itemView)
            .load(post.imageUrl)
            .transform(CenterCrop(),RoundedCorners(24))
            .into(ivPostImage)
        tvPostPublisher.text = post.publisher
        tvPostShortDescription.text = post.shortDescription
        tvPostTime.text = "${post.time} min"
        tvPostLikes.text = "${post.likes}"
    }
}