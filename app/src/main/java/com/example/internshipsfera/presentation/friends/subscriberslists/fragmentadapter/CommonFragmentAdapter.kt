package com.example.internshipsfera.presentation.friends.subscriberslists.fragmentadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.internshipsfera.R
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.databinding.ItemFriendsBinding
import com.example.internshipsfera.presentation.friends.pager2.subscriberslists.subscribersadapter.CommonItemHolder
import com.example.internshipsfera.presentation.friends.pager2.subscriberslists.subscribersadapter.diff.DiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

class CommonFragmentAdapter(private val context: Context): ListAdapterCards
<Account, CommonItemHolder>(DiffCallBack()){

    var onInterfaceItemClickListener: ((Account)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendsBinding.inflate(inflater, parent, false)
        return CommonItemHolder(binding)
    }

    override fun onBindViewHolder(holder: CommonItemHolder, position: Int) {
        val account = getItem(position)

        holder.tvName.text = account.name
        if (account.isSubscribe) {
            holder.btnSubscribe.text = context.resources.getText(R.string.subscribe)
            holder.btnSubscribe.setTextColor(context.resources.getColor(R.color.outline)) //how do without context?
        } else {
            holder.btnSubscribe.text = context.resources.getText(R.string.unsubscribe)
            holder.btnSubscribe.setTextColor( context.resources.getColor(R.color.contents87)) //how do without context?
        }

        Glide.with(context)
            .load(account.avatarUrl)
            .centerCrop()
            .into(holder.imageItem)

        holder.btnSubscribe.setOnClickListener {
            onInterfaceItemClickListener?.invoke(account)
        }
    }
}