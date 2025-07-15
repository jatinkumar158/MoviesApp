package com.example.moviesapp.presentation.di

import com.example.moviesapp.BuildConfig
import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieRemoteModule {

    @Provides
    @Singleton
    fun provideMovieRemoteModule(tmdbService: TMDBService) : MovieRemoteDataSource {
        val apiKey = "a625f72356f32ccb60261eab2e4bca87"
        return MovieRemoteDataSource(tmdbService, apiKey)
    }

}