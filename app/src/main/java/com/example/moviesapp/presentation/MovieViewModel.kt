package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase

class MovieViewModel(
    private val getMoviesListUsecase: GetMoviesListUsecase,
    private val updateMoviesListUsecase: UpdateMoviesListUsecase) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesListUsecase.invoke()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesListUsecase.invoke()
        emit(moviesList)
    }

}