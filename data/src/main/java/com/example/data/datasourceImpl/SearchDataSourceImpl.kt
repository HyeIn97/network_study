package com.example.data.datasourceImpl

import com.example.data.api.NaverApi
import com.example.data.api.SearchApi
import com.example.data.api.apiCallToFlow
import com.example.data.datasource.SearchDataSource
import com.example.data.entity.BookEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(private val searchApi: SearchApi) : SearchDataSource {
    override fun getSearch(query: String, start: Int, display: Int): Flow<NaverApi<BookEntity>> = apiCallToFlow {
        searchApi.getSearch(query, start, display)
    }
}