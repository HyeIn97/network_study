package com.example.domain.proto.usecase

import com.example.domain.proto.repository.LikeRepository

class IsLikeUseCase(private val repository: LikeRepository) {
    operator fun invoke(likeUrlKey: String) = repository.isLike(likeUrlKey)
}