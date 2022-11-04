package com.example.internshipsfera.ui.friends.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.internshipsfera.R
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.databinding.ItemFriendsBinding
import com.example.internshipsfera.ui.friends.adapter.diff.FriendsListDiffCallBack
import androidx.recyclerview.widget.ListAdapter as ListAdapterCards

class FriendsAdapter(private val context: Context): ListAdapterCards
<Account, FriendsAdapter.CardFriendItemHolder>(FriendsListDiffCallBack()){

    open class CardFriendItemHolder(val binding: ItemFriendsBinding) :
    RecyclerView.ViewHolder(binding.root)

    private val differ = AsyncListDiffer(this, FriendsListDiffCallBack())

    var accountList: List<Account>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardFriendItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendsBinding.inflate(inflater, parent, false)
        return CardFriendItemHolder(binding)
    }

    override fun onBindViewHolder(holder: CardFriendItemHolder, position: Int) {
        val account = accountList[position]
        with(holder.binding) {
            tvNameFriend.text = account.name
            if (account.isSubscribe) {
                btnSubscribe.text = context.resources.getText(R.string.subscribe)
                btnSubscribe.setTextColor(context.resources.getColor(R.color.outline))
            } else {
                btnSubscribe.text = context.resources.getText(R.string.unsubscribe)
                btnSubscribe.setTextColor(context.resources.getColor(R.color.light_grey))
            }

            Glide.with(context)
                .load(account.avatarUrl)
                .centerCrop()
                .into(imageItemFriend)

            btnSubscribe.setOnClickListener {
                itemClickListener?.let { click ->
                    click(
                        Account(
                            id = account.id,
                            name = account.name,
                            isSubscribe = !account.isSubscribe,
                            avatarUrl = account.avatarUrl
                        )
                    )
                }
            }
        }
    }

    private var itemClickListener: ((Account) -> Unit)? = null

    fun callBackSetItem(listener: (Account) -> Unit) {
        itemClickListener = listener
    }

    override fun getItemCount(): Int {
        return accountList.size
    }
}