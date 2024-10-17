package com.example.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.presentation.R

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding ?: throw IllegalStateException("base fragment binding error")

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        try {
            _binding = getViewBinding(inflater, container)
            binding.root
        } catch (e: Exception) {
            inflater.inflate(R.layout.ui_binding_expectation, container, false)
        }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}