package com.example.internshipsfera.presentation.friends.secondlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipsfera.databinding.ItemPagerSecondBinding
import com.example.internshipsfera.presentation.friends.FriendsViewModel
import com.example.internshipsfera.presentation.friends.firstlist.adapter.FirstAdapter

class SecondList : Fragment() {

    private lateinit var binding: ItemPagerSecondBinding
    private lateinit var friendsAdapter: FirstAdapter
    lateinit var friendsViewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemPagerSecondBinding.inflate(inflater, container, false)
        friendsViewModel = ViewModelProvider(requireParentFragment())[FriendsViewModel::class.java]

        val rcFriend = binding.rcFriends
        friendsAdapter = FirstAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        rcFriend.layoutManager = layoutManager
        rcFriend.adapter = friendsAdapter
        friendsViewModel.getFilteredAccountList().observe(viewLifecycleOwner){
            friendsAdapter.submitList(it)
        }

        friendsAdapter.onInterfaceItemClickListener = {friendsViewModel.changeEnableState(it)}
        return binding.root
    }
}