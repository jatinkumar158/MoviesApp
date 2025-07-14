package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.repository.MovieRepository

class GetMoviesListUsecase(private val movieRepository: MovieRepository) {
    suspend fun invoke() = movieRepository.getMoviesList()
}