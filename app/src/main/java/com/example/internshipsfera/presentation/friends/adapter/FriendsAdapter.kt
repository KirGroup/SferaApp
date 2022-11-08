package com.example.internshipsfera.presentation.friends.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.internshipsfera.R
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.databinding.ItemFriendsBinding
import com.example.internshipsfera.presentation.friends.adapter.diff.FriendsListDiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

class FriendsAdapter(private val context: Context): ListAdapterCards
<Account, FriendsAdapter.FriendItemHolder>(FriendsListDiffCallBack()){

    var onInterfaceItemClickListener: OnInterfaceItemClickListener? = null

    var accountList = listOf<Account>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendsBinding.inflate(inflater, parent, false)
        return FriendItemHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: FriendItemHolder, position: Int) {
        val account = accountList[position]

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
            onInterfaceItemClickListener?.onFunItemClick(account)
        }
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

    open class FriendItemHolder(binding: ItemFriendsBinding): RecyclerView.ViewHolder(binding.root){
        val imageItem = binding.imageItemFriend
        val tvName = binding.tvNameFriend
        val btnSubscribe = binding.btnSubscribe
    }

    interface OnInterfaceItemClickListener {
        fun onFunItemClick(account: Account)
    }

//    private var itemClickListener: ((Account) -> Unit)? = null
//
//    fun callBackSetItem(listener: (Account) -> Unit) {
//        itemClickListener = listener
//    }
}
