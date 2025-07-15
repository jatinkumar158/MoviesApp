package com.example.moviesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateBookMarkUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMoviesListUsecase: GetMoviesListUsecase,
    private val updateMoviesListUsecase: UpdateMoviesListUsecase,
    private val updateBookMarkUseCase: UpdateBookMarkUseCase) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesListUsecase.invoke()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesListUsecase.invoke()
        emit(moviesList)
    }

    fun updateBookMark(id: Int) = CoroutineScope(Dispatchers.Main).launch { updateBookMarkUseCase.invoke(id) }

    fun getBookMarkedMovies() = liveData {
        val moviesList = updateBookMarkUseCase.getBookMarkedMovies()
        emit(moviesList)
    }

}