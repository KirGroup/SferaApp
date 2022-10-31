package com.example.internshipsfera.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemFirstLineBinding
import com.example.internshipsfera.CardImage
import com.example.internshipsfera.diff.MainListDiffCallBack
import com.example.internshipsfera.adapters.MainListAdapter.*
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

abstract class MainListAdapter( val layout: Int, val list:List<Int>) : ListAdapterCards
<CardImage, MainItemHolder> (MainListDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemHolder {
        return MainItemHolder(ItemFirstLineBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainItemHolder, position: Int) {
//        val cardImageItem = getItem(position)
            //paiload
    }

    class MainItemHolder(binding: ItemFirstLineBinding): RecyclerView.ViewHolder(binding.root){
//        val itemImage: ImageView = binding.
    }

    override fun getItemCount(): Int {
        return list.size
    }
}