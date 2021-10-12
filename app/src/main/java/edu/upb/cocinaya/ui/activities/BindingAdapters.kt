package edu.upb.cocinaya.ui.activities

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("srcUrl")
fun setImageSrcUrl(imageView: ImageView, url: String?) {
    if (url != null)
        Glide.with(imageView)
            .load(url)
            .into(imageView)
}

@BindingAdapter("textInTimeFormat")
fun setTextInTimeFormat(textView: TextView, time: Long) {
    val minutes = time.div(60)
    textView.text = "$minutes min"
}