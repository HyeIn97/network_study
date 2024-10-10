package com.example.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.adapter.ViewPagerAdapter
import com.example.presentation.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() = with(binding) {
        viewPager.adapter = ViewPagerAdapter(this@MainActivity)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.search_tab)
                else -> tab.text = getString(R.string.like_tab)
            }
        }.attach()
    }
}