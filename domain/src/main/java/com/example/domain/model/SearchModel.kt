package com.example.domain.model

data class SearchModel(
    val total: Int,
    val start: Int,
    val display: Int,
    val bookList: ArrayList<BookModel>
) {
    data class BookModel(
        val title: String,
        val image: String,
        val author: String
    )
}