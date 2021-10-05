package edu.upb.cocinaya.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.google.android.material.internal.FlowLayout
import edu.upb.cocinaya.R
import edu.upb.cocinaya.data.TempDataSource
import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.ui.adapters.FeedListAdapter
import edu.upb.cocinaya.ui.interfaces.OnFeedItemClickListener

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

//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        LinearSnapHelper().attachToRecyclerView(recyclerView)

        feedListAdapter.addAll(TempDataSource.postList)



        feedListAdapter.setOnFeedItemClickListener {
            val fragment = PostDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("post", it)
                }
            }

            val ft = parentFragmentManager.beginTransaction()
            ft.add(R.id.container, fragment)
            ft.addToBackStack("Test")
            ft.commit()
        }
    }
}