package edu.upb.cocinaya.ui.mainmenu.tabs.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import edu.upb.cocinaya.R
import edu.upb.cocinaya.data.TempDataSource
import edu.upb.cocinaya.databinding.FragmentFeedBinding
import edu.upb.cocinaya.ui.mainmenu.viewmodels.UserViewModel

class FeedFragment: Fragment() {

    private val feedListAdapter = FeedListAdapter()
    private lateinit var binding: FragmentFeedBinding
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvFeed.adapter = feedListAdapter

//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFeed.layoutManager = layoutManager

        LinearSnapHelper().attachToRecyclerView(binding.rvFeed)

        feedListAdapter.addAll(TempDataSource.postList)

        feedListAdapter.setOnFeedItemClickListener {
            val directions = FeedFragmentDirections.actionGoToPostDetails(it)
            findNavController().navigate(directions)
        }

        userViewModel.user.observe(viewLifecycleOwner) {
            binding.tvWelcome.text = String.format(resources.getString(R.string.welcome_message), it?.firstName)
        }
    }
}