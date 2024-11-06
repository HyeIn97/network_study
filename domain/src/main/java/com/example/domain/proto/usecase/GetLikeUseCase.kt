package com.example.domain.proto.usecase

import com.example.domain.proto.repository.LikeRepository

class GetLikeUseCase(private val repository: LikeRepository) {
    operator fun invoke() = repository.getLike()
}