package com.berkanteruysal.fakeapiproject.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkanteruysal.fakeapiproject.R
import com.berkanteruysal.fakeapiproject.adapter.ShopAdapter
import com.berkanteruysal.fakeapiproject.databinding.ActivityMainBinding
import com.berkanteruysal.fakeapiproject.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private var shopAdapter = ShopAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.shopList.adapter = shopAdapter
        binding.shopList.layoutManager = LinearLayoutManager(this)
        viewModel.getDataFromAPI()
        setObservers()

    }


    private fun setObservers(){
        viewModel.shopData.observe(this) { list ->
            shopAdapter.updateList(list)
        }
    }
}