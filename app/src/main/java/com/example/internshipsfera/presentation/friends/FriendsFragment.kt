package com.example.internshipsfera.presentation.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipsfera.domain.Account
import com.example.internshipsfera.domain.FakeLinks
import com.example.internshipsfera.databinding.FragmentFriendsBinding
import com.example.internshipsfera.presentation.friends.adapter.FriendsAdapter

class FriendsFragment: Fragment() {

    private lateinit var binding: FragmentFriendsBinding
    private lateinit var friendsAdapter: FriendsAdapter

    private lateinit var friendsViewModel: FriendsViewModel
    private val fakeLink = FakeLinks()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)

        friendsViewModel = ViewModelProvider(this)[FriendsViewModel::class.java]
        friendsViewModel.accountList.observe(viewLifecycleOwner){
            friendsAdapter.accountList = it
        }

        val rcFriend = binding.rcFriends
        friendsAdapter = FriendsAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        rcFriend.layoutManager = layoutManager
        rcFriend.adapter = friendsAdapter

//        friendsAdapter.callBackSetItem { newItem ->
//            val list = friendsAdapter.accountList
//            val newList = mutableListOf<Account>()
//            list.forEach { oldItem ->
//                if (oldItem.id == newItem.id) {
//                    newList.add(newItem)
//                } else {
//                    newList.add(oldItem)
//                }
//            }
//            friendsAdapter.accountList = newList
//        }

        friendsAdapter.onInterfaceItemClickListener = object: FriendsAdapter.OnInterfaceItemClickListener{
            override fun onFunItemClick(account: Account) {
                friendsViewModel.changeEnableState(account)
            }
        }


        binding.toolBarFriends.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        updateUI(fakeLink.getPersonList())
//    }
//
//    private fun updateUI(friendsList: List<Account>) {
//        friendsAdapter.accountList = friendsList
//    }

}