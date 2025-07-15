package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.db.MovieDao
import com.example.moviesapp.data.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSource(private val movieDao: MovieDao) {

    suspend fun getMoviesFromDB() : List<Movie> {
        return movieDao.getMovies()
    }

    fun deleteMoviesFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovies()
        }
    }

    fun saveMoviesToDB(moviesList : List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(moviesList)
        }
    }

}