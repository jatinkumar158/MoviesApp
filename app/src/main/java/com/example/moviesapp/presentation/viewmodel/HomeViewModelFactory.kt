package com.example.moviesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateBookMarkUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase

class HomeViewModelFactory(
    private val getMoviesListUsecase: GetMoviesListUsecase,
    private val updateMoviesListUsecase: UpdateMoviesListUsecase,
    private val updateBookMarkUseCase: UpdateBookMarkUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return HomeViewModel(getMoviesListUsecase, updateMoviesListUsecase, updateBookMarkUseCase) as T
    }
}