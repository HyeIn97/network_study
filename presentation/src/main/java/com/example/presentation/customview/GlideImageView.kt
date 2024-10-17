package com.example.presentation.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.presentation.R

class GlideImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatImageView(context, attrs){
    fun setThumbnailUrl(url: String){
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.ic_empty_image)
            .thumbnail(Glide.with(this.context).asDrawable().sizeMultiplier(0.1f))
            .into(this)
    }

    fun setUrl(url: String){
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.ic_empty_image)
            .into(this)
    }
}