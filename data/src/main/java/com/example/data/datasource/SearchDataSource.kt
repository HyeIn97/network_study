package com.example.data.datasource

import com.example.data.api.NaverApi
import com.example.data.entity.BookEntity
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    fun getSearch(query: String, start: Int, display: Int): Flow<NaverApi<BookEntity>>
}