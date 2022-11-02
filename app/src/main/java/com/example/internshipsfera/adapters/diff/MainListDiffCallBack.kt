package com.example.internshipsfera.adapters.diff

import androidx.recyclerview.widget.DiffUtil

class MainListDiffCallBack: DiffUtil.ItemCallback<CardImage>(){
    override fun areItemsTheSame(oldItem: CardImage, newItem: CardImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardImage, newItem: CardImage): Boolean {
        return oldItem==newItem
    }
}
