package com.example.moviesapp.data.repository

import android.util.Log
import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.movie.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMoviesList(): List<Movie>? {
        return getMoviesCache()
    }

    override suspend fun updateMoviesList(): List<Movie>? {
        val moviesList = getMoviesFromAPI()
        movieLocalDataSource.deleteMoviesFromDB()
        movieLocalDataSource.saveMoviesToDB(moviesList)
        movieCacheDataSource.updateMovies(moviesList)
        return moviesList
    }

    override suspend fun addBookMark(id: Int) {
        movieLocalDataSource.updateBookMark(id)
        movieCacheDataSource.updateBookMark(id)
    }

    override suspend fun getBookmarkedMovies(): List<Movie>? {
        return movieLocalDataSource.getBookMarkedMovies()
    }

    private suspend fun getMoviesFromAPI() : List<Movie> {
        var moviesList: List<Movie> = ArrayList()
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                moviesList = body.movies
            }
        } catch (e: Exception) {
            Log.d("jatin", "error while fetching data from API ${e.message}")
        }
        return moviesList
    }

    private suspend fun getMoviesFromDB() : List<Movie> {
        var moviesList: List<Movie> = ArrayList()
        try {
            moviesList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.d("jatin", "error while fetching data from DB ${e.message}")
        }
        if (moviesList.isNotEmpty()) {
            movieCacheDataSource.updateMovies(moviesList)
        } else {
            moviesList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(moviesList)
        }
        return moviesList
    }

    private suspend fun getMoviesCache() : List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieCacheDataSource.getMovies()
        } catch (e: Exception) {
            Log.d("jatin", "error while fetching data from Cache")
        }
        if (moviesList.isEmpty()) {
            moviesList = getMoviesFromDB()
        }
        return moviesList
    }

}