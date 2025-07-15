package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase

class MovieViewModelFactory(
    private val getMoviesListUsecase: GetMoviesListUsecase,
    private val updateMoviesListUsecase: UpdateMoviesListUsecase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MovieViewModel(getMoviesListUsecase, updateMoviesListUsecase) as T
    }
}

// Application class @HiltAndroidApp
// No need for component interface
// For modules use @Installin(SingleTon...
// for activity class, no inject is required @AndroidEntryPoint