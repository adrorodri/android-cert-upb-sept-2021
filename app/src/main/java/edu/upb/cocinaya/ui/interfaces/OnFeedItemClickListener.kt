package edu.upb.cocinaya.ui.interfaces

import edu.upb.cocinaya.model.Post

interface OnFeedItemClickListener {
    fun onItemClick(post: Post)
}