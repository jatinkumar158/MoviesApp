package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.api.TMDBService

class MovieRemoteDataSource(private val tmdbService: TMDBService,
    private val apiKey: String){

    suspend fun getMovies() = tmdbService.getLatestMovies(apiKey);

}