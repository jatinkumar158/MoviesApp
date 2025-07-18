package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.movie.Movie
import javax.inject.Inject

class MovieCacheDataSource @Inject constructor() {

    private var moviesList : ArrayList<Movie> = ArrayList()

    fun getMovies() : List<Movie> {
        return moviesList
    }

    fun updateMovies(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

    fun updateBookMark(id: Int) {
        for (i in 0..moviesList.size) {
            if (moviesList[i].id == id) {
                moviesList[i].isBookMarked = !moviesList[i].isBookMarked
                break
            }
        }
    }


}