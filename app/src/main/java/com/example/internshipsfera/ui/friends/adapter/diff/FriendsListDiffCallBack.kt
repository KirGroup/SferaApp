package com.example.internshipsfera.ui.friends.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.internshipsfera.data.Account

class FriendsListDiffCallBack: DiffUtil.ItemCallback<Account>(){
    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem==newItem
    }
}