package com.example.internshipsfera.presentation.profile.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.internshipsfera.domain.Account

class ProfileListDiffCallBack: DiffUtil.ItemCallback<Account>(){
    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem==newItem
    }
}