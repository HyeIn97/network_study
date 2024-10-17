package com.example.domain.usecase

import com.example.domain.repository.SearchRepository

class GetSearchUseCase(private val searchRepository: SearchRepository) {
    suspend operator fun invoke(query: String, start: Int, display: Int) = searchRepository.getSearch(query, start, display)
}