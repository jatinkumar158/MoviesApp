package com.example.moviesapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.db.MovieDao
import com.example.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context) : TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb_client").build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

}