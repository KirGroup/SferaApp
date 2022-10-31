package com.example.internshipsfera.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemChroniclesBinding
import com.example.internshipsfera.CardImage

import com.example.internshipsfera.diff.ChronicDiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards


class ChronicAdapter: ListAdapterCards<CardImage, ChronicAdapter.CardImageItemHolder>(
    ChronicDiffCallBack()//заменить на один!!!!!!!!!!
){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageItemHolder {
        return CardImageItemHolder(ItemChroniclesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CardImageItemHolder, position: Int) {
//        holder.itemImage.setImageResource(R.drawable.first_item)
    }

    class CardImageItemHolder(binding: ItemChroniclesBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun getItemCount(): Int {
        return 12
    }
}