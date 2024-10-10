package com.example.presentation.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.presentation.ui.LikeFragment
import com.example.presentation.ui.SearchFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> SearchFragment()
        else -> LikeFragment()
    }
}