package com.example.presentation.util

interface ItemClickListener<T> {
    fun itemClick(position: Int, data: T) {}
}