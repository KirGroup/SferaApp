package com.example.internshipsfera.presentation.friends.pager2.subscriberslists.subscribersadapter

import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemFriendsBinding

open class CommonItemHolder(binding: ItemFriendsBinding): RecyclerView.ViewHolder(binding.root){
    val imageItem = binding.imageItemFriend
    val tvName = binding.tvNameFriend
    val btnSubscribe = binding.btnSubscribe
}