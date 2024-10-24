package com.example.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLikeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : BaseFragment<FragmentLikeBinding>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentLikeBinding.inflate(inflater, container, false)
}