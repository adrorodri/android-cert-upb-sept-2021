package edu.upb.cocinaya.ui.fragments

import androidx.fragment.app.Fragment

fun Fragment.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

fun Fragment.pxToDp(px: Int): Int {
    return (px / resources.displayMetrics.density).toInt()
}