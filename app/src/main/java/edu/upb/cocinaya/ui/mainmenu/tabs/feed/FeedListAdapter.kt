package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.upb.cocinaya.databinding.ListItemFeedBinding
import edu.upb.cocinaya.model.Post

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
        binding.post = post
    }
}