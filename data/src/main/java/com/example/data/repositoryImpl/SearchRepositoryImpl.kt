package com.example.data.repositoryImpl

import com.example.data.datasource.SearchDataSource
import com.example.data.helper.SearchHelper
import com.example.domain.model.SearchModel
import com.example.domain.repository.SearchRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchDataSource: SearchDataSource) : SearchRepository {
    private val helper = SearchHelper()

    override suspend fun getSearch(query: String, start: Int, display: Int): Result<SearchModel>  {
      return Result.success(helper.searchEntityToModel(searchDataSource.getSearch(query, start, display).first()))
    }
}