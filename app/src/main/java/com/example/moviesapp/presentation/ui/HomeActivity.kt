package com.example.moviesapp.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityHomeBinding
import com.example.moviesapp.presentation.viewmodel.HomeViewModel
import com.example.moviesapp.presentation.viewmodel.HomeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        initRecyclerView()

        binding.showAllButton.setOnClickListener {
            getMovies()
        }

        binding.showBookmarksButton.setOnClickListener {
            getBookMarkedMovies()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.more_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.update_button -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieRecyclerViewAdapter(homeViewModel)
        binding.movieRecyclerView.adapter = adapter
        getMovies()
        binding.progressBar.visibility = View.GONE
    }

    private fun getMovies() {
        val movies = homeViewModel.getMovies()
        movies.observe(this, Observer {
            if (it != null) {
                adapter.setMoviesList(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun getBookMarkedMovies() {
        val movies = homeViewModel.getBookMarkedMovies()
        movies.observe(this, Observer {
            if (it != null) {
                adapter.setMoviesList(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Refreshing data", Toast.LENGTH_SHORT).show()
        val movies = homeViewModel.updateMovies()
        movies.observe(this, Observer {
            if (it != null) {
                adapter.setMoviesList(it)
                adapter.notifyDataSetChanged()
            }
        })
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

}