package com.example.data.api

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

data class NaverApi<T>(
    val total: Int,
    val start: Int,
    val display: Int,
    val items: ArrayList<T>
)

fun <T> apiCallToFlow(data: suspend () -> Response<NaverApi<T>>): Flow<NaverApi<T>> = flow {
    try {
        val response = data()
        if (response.isSuccessful) {
            val apiResponse = response.body()
            if (apiResponse != null) {
                emit(apiResponse)
            } else {
                throw NullPointerException("Response body is null")
            }
        } else {
            val errorBody = response.errorBody()?.string()
            if (errorBody != null) {
                Log.d("debug", "errorBody : $errorBody")
                throw HttpException(response)
            } else {
                throw HttpException(response)
            }
        }
    } catch (e: IOException) {
        throw e
    }
}