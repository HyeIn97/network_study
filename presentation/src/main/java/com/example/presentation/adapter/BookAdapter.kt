package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SearchModel
import com.example.presentation.databinding.ItemBookBinding

class BookAdapter(private val list: ArrayList<SearchModel.BookModel>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchModel.BookModel) {
            binding.run {
                bookImage.setThumbnailUrl(item.image)
                bookTitle.text = item.title
                bookAuthor.text = item.author
            }
        }
    }
}