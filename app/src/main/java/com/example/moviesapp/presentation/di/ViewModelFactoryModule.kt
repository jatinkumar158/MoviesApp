package com.example.moviesapp.presentation.di

import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateBookMarkUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase
import com.example.moviesapp.presentation.viewmodel.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideMovieViewModelFactoryModule(getMoviesListUsecase: GetMoviesListUsecase, updateMoviesListUsecase: UpdateMoviesListUsecase, updateBookMarkUseCase: UpdateBookMarkUseCase) : HomeViewModelFactory {
        return HomeViewModelFactory(getMoviesListUsecase, updateMoviesListUsecase, updateBookMarkUseCase)
    }

}