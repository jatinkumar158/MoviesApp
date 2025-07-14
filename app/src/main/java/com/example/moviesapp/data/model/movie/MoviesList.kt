package com.example.moviesapp.data.model.movie


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results")
    val movies: List<Movie>
)