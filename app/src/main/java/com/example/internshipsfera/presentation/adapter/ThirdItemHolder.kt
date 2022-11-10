package com.example.internshipsfera.presentation.friends.firstlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemFriendsBinding

open class ThirdItemHolder(binding: ItemFriendsBinding): RecyclerView.ViewHolder(binding.root){
    val imageItem = binding.imageItemFriend
    val tvName = binding.tvNameFriend
    val btnSubscribe = binding.btnSubscribe
}