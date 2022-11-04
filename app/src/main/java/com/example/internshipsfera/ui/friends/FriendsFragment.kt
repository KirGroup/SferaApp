package com.example.internshipsfera.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.data.FakeLinks
import com.example.internshipsfera.databinding.FragmentFriendsBinding
import com.example.internshipsfera.ui.friends.adapter.FriendsAdapter

class FriendsFragment: Fragment() {

    private lateinit var binding: FragmentFriendsBinding
    private lateinit var friendsAdapter: FriendsAdapter

    private val fakeLink = FakeLinks()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)

        val rcFriend = binding.rcFriends
        friendsAdapter = FriendsAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext())
        rcFriend.layoutManager = layoutManager
        rcFriend.adapter = friendsAdapter

        friendsAdapter.callBackSetItem { newItem ->
            val list = friendsAdapter.accountList
            val newList = mutableListOf<Account>()
            list.forEach { oldItem ->
                if (oldItem.id == newItem.id) {
                    newList.add(newItem)
                } else {
                    newList.add(oldItem)
                }
            }
            friendsAdapter.accountList = newList
        }

        binding.toolBarFriends.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI(fakeLink.getPersonList())
    }

    private fun updateUI(personList: List<Account>) {
        friendsAdapter.accountList = personList
    }
}