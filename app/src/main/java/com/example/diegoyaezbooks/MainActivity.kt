package com.example.diegoyaezbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.diegoyaezbooks.model.MyViewModel
import com.example.diegoyaezbooks.view.ListingFragment

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLog()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,ListingFragment()).commit()

        //viewModel.DoSomrething()

    }
    private fun initLog(){}
}