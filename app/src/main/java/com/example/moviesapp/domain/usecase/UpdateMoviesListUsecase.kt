package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.repository.MovieRepository

class UpdateMoviesListUsecase(private val movieRepository: MovieRepository) {
    suspend fun invoke() = movieRepository.updateMoviesList()
}