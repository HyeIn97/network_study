package com.example.presentation.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.model.DetailModel
import com.example.presentation.databinding.ActivityDetailBinding
import com.example.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)

        viewModel.detailModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", DetailModel::class.java)
        } else {
            intent.getParcelableExtra("data")
        }

        initView()
        listener()
    }

    private fun initView() = with(binding) {
        detailImage.setUrl(viewModel.detailModel?.image ?: "")
        detailTitle.text = viewModel.detailModel?.title ?: ""
    }

    private fun listener() = with(binding) {
        backBtn.setOnClickListener {
            finish()
        }

        likeBtn.setOnClickListener {
            likeBtn.isChecked
        }
    }
}