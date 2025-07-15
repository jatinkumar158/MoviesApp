package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.movie.Movie

interface MovieRepository {

    suspend fun getMoviesList() : List<Movie>?
    suspend fun updateMoviesList(): List<Movie>?

    suspend fun addBookMark(id: Int)

    suspend fun getBookmarkedMovies() : List<Movie>?

}