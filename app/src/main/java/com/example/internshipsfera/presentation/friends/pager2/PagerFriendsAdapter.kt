package com.example.internshipsfera.presentation.friends.pager2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.internshipsfera.presentation.friends.FriendsFragment
import com.example.internshipsfera.presentation.friends.pager2.subscriberslists.firstlist.FirstList
import com.example.internshipsfera.presentation.friends.pager2.subscriberslists.secondlist.SecondList
import com.example.internshipsfera.presentation.friends.pager2.subscriberslists.thirdlist.ThirdList

class PagerFriendsAdapter(fragment: FriendsFragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstList()
            1 -> SecondList()
            2 -> ThirdList()
            else -> FirstList()
        }
    }
}