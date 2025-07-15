package com.example.moviesapp.presentation.di

import com.example.moviesapp.domain.usecase.GetMoviesListUsecase
import com.example.moviesapp.domain.usecase.UpdateMoviesListUsecase
import com.example.moviesapp.presentation.MovieViewModelFactory
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
    fun provideMovieViewModelFactoryModule(getMoviesListUsecase: GetMoviesListUsecase, updateMoviesListUsecase: UpdateMoviesListUsecase) : MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesListUsecase, updateMoviesListUsecase)
    }

}