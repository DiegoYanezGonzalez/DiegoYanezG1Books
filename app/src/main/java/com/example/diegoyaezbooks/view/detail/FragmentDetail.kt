package com.example.diegoyaezbooks.view.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.diegoyaezbooks.databinding.FragmentDetailBinding
import com.example.diegoyaezbooks.MyViewModel

class FragmentDetail : Fragment(){

private lateinit var binding:FragmentDetailBinding

private val vm : MyViewModel by activityViewModels()

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    binding = FragmentDetailBinding.inflate(layoutInflater)

    vm.getDetail().observe(viewLifecycleOwner,{detail ->
        binding.tvTitleDetail.text= detail.title
       // binding.tvAuthor.text=detail.author
        //binding.tvCountryDetail.text=detail.country

        binding.floatingShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,detail.toString())
            startActivity(intent)
        }

    })
        return binding.root


}
}