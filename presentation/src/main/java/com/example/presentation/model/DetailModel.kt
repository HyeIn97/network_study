package com.example.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailModel(
    val title: String,
    val image: String
) : Parcelable