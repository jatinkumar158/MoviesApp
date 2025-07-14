package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMoviesList() : List<Movie>?
    suspend fun updateMoviesList(): List<Movie>?

}