package com.example.internshipsfera.presentation.friends

import android.app.ActionBar
import android.content.res.Resources
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.internshipsfera.R
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.databinding.FragmentFriendsBinding
import com.example.internshipsfera.presentation.friends.pager2.PagerFriendsAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FriendsFragment: Fragment() {

    private lateinit var binding: FragmentFriendsBinding

    lateinit var friendsViewModel: FriendsViewModel
//    lateinit var listAllItems: List<Account>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)

        friendsViewModel = ViewModelProvider(this)[FriendsViewModel::class.java]
//        friendsViewModel.allAccountList.observe(viewLifecycleOwner){
//            listAllItems = it
//        }
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager2

        viewPager.adapter = PagerFriendsAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = when(position){
                0 -> resources.getString(R.string.subscribers)
                1 -> resources.getString(R.string.subscriptions)
                2 -> resources.getString(R.string.mutually)
                else -> {throw Resources.NotFoundException("Position not found")}
            }
        }.attach()

        binding.toolBarFriends.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolBarFriends)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_friends, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val menuItem: MenuItem = menu.findItem(R.id.search_friend)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object: OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!=null) {
                    var listFiltered = friendsViewModel.allAccountList.value?.filter {
                        it.name.contains(newText, true)
                    }
                    friendsViewModel.filteredAccountList.value = listFiltered
                }
                return false
            }
        })

    }
}