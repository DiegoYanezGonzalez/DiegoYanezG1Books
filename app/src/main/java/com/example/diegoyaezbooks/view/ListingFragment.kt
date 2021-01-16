package com.example.diegoyaezbooks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diegoyaezbooks.databinding.FragmentListingBinding
import com.example.diegoyaezbooks.model.MyViewModel

class ListingFragment : Fragment() {

    private lateinit var binding : FragmentListingBinding
    private val vm : MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListingBinding.inflate(layoutInflater)
        binding.rvBooksList.layoutManager = LinearLayoutManager(context)

        val adapter = BooksAadapter()
        binding.rvBooksList.adapter = adapter

        vm.books().observe(viewLifecycleOwner,{
            adapter.update(it)
        })
        return binding.root


    }

}