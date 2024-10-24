package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.presentation.model.DetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    var detailModel: DetailModel? = null
}