package com.example.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM movie_table")
    suspend fun getMovies() : List<Movie>

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()

    @Query("UPDATE movie_table SET isBookMarked = NOT isBookMarked WHERE id = :id")
    suspend fun toggleBookMark(id: Int)

    @Query("SELECT * FROM movie_table WHERE isBookMarked = 1")
    suspend fun getBookmarkedMovies() : List<Movie>

}