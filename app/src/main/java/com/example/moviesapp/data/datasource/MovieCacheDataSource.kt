package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.model.movie.Movie

class MovieCacheDataSource {

    private lateinit var moviesList : ArrayList<Movie>

    fun getMovies() : List<Movie> {
        return moviesList
    }

    fun updateMovies(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }


}