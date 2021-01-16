package com.example.diegoyaezbooks.view.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diegoyaezbooks.R
import com.example.diegoyaezbooks.databinding.FragmentListingBinding
import com.example.diegoyaezbooks.MyViewModel
import com.example.diegoyaezbooks.view.detail.FragmentDetail

class ListingFragment : Fragment() {

    private lateinit var binding : FragmentListingBinding
    private val vm : MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListingBinding.inflate(layoutInflater)
        binding.rvBooksList.layoutManager = LinearLayoutManager(context)

        val adapter = BooksAadapter()
        binding.rvBooksList.adapter = adapter

        adapter.selectedItem().observe(viewLifecycleOwner, {
            Log.d("click","hicimos click en $it")


            vm.selected(it)



            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,FragmentDetail())?.addToBackStack("detail")?.commit()
        })

        vm.books().observe(viewLifecycleOwner,{
            adapter.update(it)
        })
        return binding.root


    }

}