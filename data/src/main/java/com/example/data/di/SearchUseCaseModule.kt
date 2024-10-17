package com.example.data.di

import com.example.domain.repository.SearchRepository
import com.example.domain.usecase.GetSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchUseCaseModule {
    @Provides
    @Singleton
    fun providerSearchGetUseCase(searchRepository: SearchRepository) = GetSearchUseCase(searchRepository)
}