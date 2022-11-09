package com.example.internshipsfera.presentation.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.example.internshipsfera.databinding.FragmentFriendsBinding
import com.example.internshipsfera.presentation.friends.adapter.FriendsAdapter
import com.example.internshipsfera.presentation.friends.pager2.SubscribersPagerAdapter

class FriendsFragment: Fragment() {

    private lateinit var binding: FragmentFriendsBinding
    private lateinit var friendsAdapter: FriendsAdapter

    private lateinit var friendsViewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)

        friendsViewModel = ViewModelProvider(this)[FriendsViewModel::class.java]
//        friendsViewModel.accountList.observe(viewLifecycleOwner){
//            friendsAdapter.submitList(it)
//        }

        binding.viewPager2.adapter = SubscribersPagerAdapter()

//        val rcFriend = binding.rcFriends
//        friendsAdapter = FriendsAdapter(requireContext())
//        val layoutManager = LinearLayoutManager(requireContext())
//        rcFriend.layoutManager = layoutManager
//        rcFriend.adapter = friendsAdapter
//
//        friendsAdapter.onInterfaceItemClickListener = {friendsViewModel.changeEnableState(it)}

        binding.toolBarFriends.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }
}