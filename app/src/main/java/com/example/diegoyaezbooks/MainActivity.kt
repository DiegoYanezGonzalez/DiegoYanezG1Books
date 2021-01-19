package com.example.diegoyaezbooks

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diegoyaezbooks.view.list.ListingFragment

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, ListingFragment()).commit()

    }
}