package com.example.moviesapp.presentation.di

import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateBookMarkUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieListUseCase(movieRepository: MovieRepository): GetMoviesListUsecase {
        return GetMoviesListUsecase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateMovieListUseCase(movieRepository: MovieRepository): UpdateMoviesListUsecase {
        return UpdateMoviesListUsecase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateBookMarkUseCase(movieRepository: MovieRepository) : UpdateBookMarkUseCase {
        return UpdateBookMarkUseCase(movieRepository)
    }

}