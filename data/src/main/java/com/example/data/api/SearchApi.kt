package com.example.data.api

import com.example.data.entity.BookEntity
import com.example.data.remote.apirul.ApiUrl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET(ApiUrl.book)
    suspend fun getSearch(
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int
    ): Response<NaverApi<BookEntity>>
}
