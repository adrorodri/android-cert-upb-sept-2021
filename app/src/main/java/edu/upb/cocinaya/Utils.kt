package edu.upb.cocinaya

import android.content.Context
import androidx.core.content.ContextCompat.getSystemService

import android.net.ConnectivityManager
import androidx.core.content.ContextCompat


fun isNetworkConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
}