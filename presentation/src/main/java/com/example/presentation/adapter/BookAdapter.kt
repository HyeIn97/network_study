package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.search.model.SearchModel
import com.example.presentation.databinding.ItemBookBinding
import com.example.presentation.model.DetailLikeModel
import com.example.presentation.util.ItemClickListener

class BookAdapter(private val list: ArrayList<SearchModel.BookModel>, private val clickListener: ItemClickListener<DetailLikeModel>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                clickListener.itemClick(
                    adapterPosition,
                    DetailLikeModel(
                        list[adapterPosition].title,
                        list[adapterPosition].image,
                        list[adapterPosition].author,
                        list[adapterPosition].link
                    )
                )
            }
        }

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