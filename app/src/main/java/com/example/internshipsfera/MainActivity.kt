package com.example.internshipsfera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ActivityMainBinding
import com.example.internshipsfera.ui.profile.adapters.ChronicAdapter
import com.example.internshipsfera.ui.profile.adapters.FirstAdapter
import com.example.internshipsfera.ui.profile.adapters.MomentsAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}