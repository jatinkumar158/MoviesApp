package com.example.moviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.movie.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
}