package com.example.moviesapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.movie.Movie
import com.example.moviesapp.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        val movie = intent.getSerializableExtra("movie") as Movie
        binding.movieTitle.text = movie.title
        val imageURL = "https://image.tmdb.org/t/p/original/" + movie.posterPath
        Glide.with(binding.movieImage.context).load(imageURL).into(binding.movieImage)
        binding.movieDescription.text = movie.overview


    }
}