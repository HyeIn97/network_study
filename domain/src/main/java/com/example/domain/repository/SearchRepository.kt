package com.example.domain.repository

import com.example.domain.model.SearchModel

interface SearchRepository {
    suspend fun getSearch(query: String, start: Int, display: Int): Result<SearchModel>
}