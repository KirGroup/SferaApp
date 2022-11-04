package com.example.internshipsfera.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipsfera.R
import com.example.internshipsfera.databinding.FragmentAccountBinding
import com.example.internshipsfera.ui.profile.adapters.ChronicAdapter
import com.example.internshipsfera.ui.profile.adapters.FirstAdapter
import com.example.internshipsfera.ui.profile.adapters.MomentsAdapter

class AccountFragment: Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var firstAdapter: FirstAdapter
    private lateinit var momentsAdapter: MomentsAdapter
    private lateinit var chronicAdapter: ChronicAdapter

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)

        firstAdapter = FirstAdapter()
        val firstRc: RecyclerView = binding.rcFirst
        firstRc.adapter = firstAdapter

        momentsAdapter = MomentsAdapter()
        val momentsRc = binding.rcMoments
        momentsRc.adapter = momentsAdapter

        chronicAdapter = ChronicAdapter()
        val chronicRc = binding.rcChronicles
        chronicRc.setLayoutManager(GridLayoutManager(requireContext(), 3))
        chronicRc.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        chronicRc.adapter = chronicAdapter

        binding.btnPeople.setOnClickListener {
            findNavController().navigate(R.id.nav_accountFrag_to_friendsFrag)
        }

        binding.textInputLayout.setOnFocusChangeListener { _, _ ->
            binding.textInputLayout.counterTextColor = getColorStateList(requireContext(), R.color.outline)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            tvAboutMe.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
                if (focus) {
                    textInputLayout.counterTextColor = getColorStateList(
                        requireContext(),
                        R.color.purple_200
                    )
                } else {
                    textInputLayout.counterTextColor = getColorStateList(
                        requireContext(),
                        R.color.contents87
                    )
                }
            }
        }
    }

}