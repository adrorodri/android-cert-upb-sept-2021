package edu.upb.cocinaya.model.interfaces

import edu.upb.cocinaya.model.Post

interface OnFeedItemClickListener {
    fun onItemClick(post: Post)
}