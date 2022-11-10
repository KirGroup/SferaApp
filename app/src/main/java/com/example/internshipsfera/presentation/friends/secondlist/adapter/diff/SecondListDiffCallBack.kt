package com.example.internshipsfera.presentation.friends.firstlist.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.internshipsfera.data.Account

class SecondListDiffCallBack: DiffUtil.ItemCallback<Account>(){
    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem==newItem
    }

    override fun getChangePayload(oldItem: Account, newItem: Account): Any? {
        return oldItem.isSubscribe != newItem.isSubscribe
    }
}