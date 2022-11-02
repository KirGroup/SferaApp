package com.example.internshipsfera.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemFirstLineBinding
import com.example.internshipsfera.adapters.diff.MainListDiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

class FirstAdapter: ListAdapterCards
<CardImage, FirstAdapter.CardImageItemHolder> (MainListDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageItemHolder {
        return CardImageItemHolder(ItemFirstLineBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CardImageItemHolder, position: Int) {
//        holder.itemImage.setImageResource(R.drawable.first_item)
    }

    class CardImageItemHolder(binding: ItemFirstLineBinding): RecyclerView.ViewHolder(binding.root){
//        val itemImage: ImageView = binding.firstItemImage
    }

    override fun getItemCount(): Int {
        return 4
    }
}