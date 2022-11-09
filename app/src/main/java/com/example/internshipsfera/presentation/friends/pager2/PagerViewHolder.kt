package com.example.internshipsfera.presentation.friends.pager2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.R
import com.example.internshipsfera.databinding.FragmentAccountBinding
import com.example.internshipsfera.databinding.ItemFriendsSubscribersBinding

class PagerViewHolder(binding: ItemFriendsSubscribersBinding) : RecyclerView.ViewHolder(binding.root){
    val text = binding.tvTitle
    val container = binding.container
}