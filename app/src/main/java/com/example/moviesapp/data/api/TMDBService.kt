package com.example.moviesapp.data.api

import com.example.moviesapp.data.model.movie.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/now_playing")
    suspend fun getLatestMovies(@Query("api_key") apiKey: String) : Response<MoviesList>

}