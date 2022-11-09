package com.example.internshipsfera.presentation.friends.pager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.R
import com.example.internshipsfera.databinding.ItemFriendsSubscribersBinding

class SubscribersPagerAdapter: RecyclerView.Adapter<PagerViewHolder>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(ItemFriendsSubscribersBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.text.text = "item $position"
        holder.container.setBackgroundResource(colors[position])
    }

    override fun getItemCount(): Int = colors.size

}
