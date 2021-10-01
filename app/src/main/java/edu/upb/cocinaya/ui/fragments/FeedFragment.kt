package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.cocinaya.R
import edu.upb.cocinaya.data.TempDataSource
import edu.upb.cocinaya.ui.adapters.FeedListAdapter

class FeedFragment: Fragment() {

    private val feedListAdapter = FeedListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvFeed)
        recyclerView.adapter = feedListAdapter

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        feedListAdapter.addAll(TempDataSource.postList)
    }
}