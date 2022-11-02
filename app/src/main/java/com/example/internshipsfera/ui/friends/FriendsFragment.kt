package com.example.internshipsfera.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.internshipsfera.databinding.FrigmentFriendsBinding

class FriendsFragment: Fragment() {

    lateinit var binding: FrigmentFriendsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrigmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        with(binding){
//            toolBarFriends.setNavigationOnClickListener {
//            }
//        }
//    }

}