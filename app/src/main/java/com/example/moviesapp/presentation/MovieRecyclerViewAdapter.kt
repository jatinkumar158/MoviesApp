package com.example.moviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.movie.Movie
import com.example.moviesapp.databinding.ListItemBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setMoviesList(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.listItemTitle.text = movie.title
        val imageURL = "https://image.tmdb.org/t/p/original/" + movie.posterPath
        Glide.with(binding.listItemImage.context).load(imageURL).into(binding.listItemImage)
    }

}