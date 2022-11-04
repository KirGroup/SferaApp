package com.example.internshipsfera.ui.profile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ItemChroniclesBinding
import com.example.internshipsfera.ui.profile.adapters.diff.ProfileListDiffCallBack
import com.example.internshipsfera.data.Account
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

class ChronicAdapter: ListAdapterCards
<Account, ChronicAdapter.CardImageItemHolder>(ProfileListDiffCallBack()){

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