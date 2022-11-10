package com.example.internshipsfera.presentation.friends.firstlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipsfera.databinding.ItemPagerBinding
import com.example.internshipsfera.presentation.friends.FriendsViewModel
import com.example.internshipsfera.presentation.friends.fragmentadapter.CommonFragmentAdapter

class FirstList : Fragment() {

    private lateinit var binding: ItemPagerBinding
    private lateinit var friendsAdapter: CommonFragmentAdapter
    lateinit var friendsViewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemPagerBinding.inflate(inflater, container, false)
        friendsViewModel = ViewModelProvider(requireParentFragment())[FriendsViewModel::class.java]

        val rcFriend = binding.rcFriends
        friendsAdapter = CommonFragmentAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        rcFriend.layoutManager = layoutManager
        rcFriend.adapter = friendsAdapter
//        friendsViewModel.filteredAccountList.observe(viewLifecycleOwner){
////            it.filter {
////                it-> it.isSubscribe //фильтровать по задаче
////            }
//            friendsAdapter.submitList(it)
//        }

        friendsAdapter.onInterfaceItemClickListener = {friendsViewModel.changeEnableState(it)}
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        friendsViewModel.getFilteredAccountList().observe(viewLifecycleOwner){
            friendsAdapter.submitList(it)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}