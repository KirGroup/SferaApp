package com.example.internshipsfera.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.internshipsfera.CardImage

class MomentsDiffCallBack: DiffUtil.ItemCallback<CardImage>() {
    override fun areItemsTheSame(oldItem: CardImage, newItem: CardImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardImage, newItem: CardImage): Boolean {
        return oldItem == newItem
    }
}