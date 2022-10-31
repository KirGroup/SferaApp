package com.example.internshipsfera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.databinding.ActivityMainBinding
import com.example.internshipsfera.adapters.ChronicAdapter
import com.example.internshipsfera.adapters.FirstAdapter
import com.example.internshipsfera.adapters.MomentsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var firstAdapter: FirstAdapter
    private lateinit var momentsAdapter: MomentsAdapter
    private lateinit var chronicAdapter: ChronicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firstAdapter = FirstAdapter()
        val firstRc: RecyclerView = binding.rcFirst
        firstRc.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        firstRc.adapter = firstAdapter

        momentsAdapter = MomentsAdapter()
        val momentsRc = binding.rcMoments
        momentsRc.adapter = momentsAdapter

        chronicAdapter = ChronicAdapter()
        val chronicRc = binding.rcChronicles
        chronicRc.setLayoutManager(GridLayoutManager(applicationContext, 3))

        chronicRc.adapter = chronicAdapter
    }
}