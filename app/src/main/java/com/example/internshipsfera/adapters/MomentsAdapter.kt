package com.example.internshipsfera.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemMomentsBinding
import com.example.internshipsfera.CardImage
import com.example.internshipsfera.diff.MomentsDiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards


class MomentsAdapter: ListAdapterCards <CardImage, MomentsAdapter.CardImageItemHolder> (
    MomentsDiffCallBack()
){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageItemHolder {
        return CardImageItemHolder(ItemMomentsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CardImageItemHolder, position: Int) {
//        holder.itemImage.setImageResource(R.drawable.moment_item)
    }

    class CardImageItemHolder(binding: ItemMomentsBinding): RecyclerView.ViewHolder(binding.root){
//        val itemImage: ImageView = binding.momentsItemImage
    }

    override fun getItemCount(): Int {
        return 6
    }
}