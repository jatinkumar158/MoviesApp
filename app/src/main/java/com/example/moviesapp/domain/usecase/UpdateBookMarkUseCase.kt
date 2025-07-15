package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.repository.MovieRepository

class UpdateBookMarkUseCase(private val movieRepository: MovieRepository) {
    suspend fun invoke(id: Int) = movieRepository.addBookMark(id)
    suspend fun getBookMarkedMovies() = movieRepository.getBookmarkedMovies()
}