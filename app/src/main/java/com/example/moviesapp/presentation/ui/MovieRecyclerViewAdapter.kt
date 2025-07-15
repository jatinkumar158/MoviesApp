package com.example.moviesapp.presentation.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.movie.Movie
import com.example.moviesapp.databinding.ListItemBinding
import com.example.moviesapp.presentation.viewmodel.HomeViewModel

class MovieRecyclerViewAdapter(private val homeViewModel: HomeViewModel) : RecyclerView.Adapter<MovieViewHolder>() {

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
        return MovieViewHolder(binding, homeViewModel)
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

class MovieViewHolder(val binding: ListItemBinding, val homeViewModel: HomeViewModel) : RecyclerView.ViewHolder(binding.root) {

    val context = binding.root.context
    fun bind(movie: Movie) {
        binding.listItemTitle.text = movie.title
        val imageURL = "https://image.tmdb.org/t/p/original/" + movie.posterPath
        Glide.with(binding.listItemImage.context).load(imageURL).into(binding.listItemImage)
        binding.listItemContainer.setOnClickListener {

            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra("movie", movie)
            context.startActivity(intent)
        }
        if (movie.isBookMarked) {
            binding.listItemBookmarked.setImageDrawable(context.getDrawable(R.drawable.star_filled))
        } else {
            binding.listItemBookmarked.setImageDrawable(context.getDrawable(R.drawable.star_outline))
        }

        binding.listItemBookmarked.setOnClickListener {
            if (movie.isBookMarked) {
                Toast.makeText(context, "Bookmark removed", Toast.LENGTH_SHORT).show()
                binding.listItemBookmarked.setImageDrawable(context.getDrawable(R.drawable.star_outline))
            } else {
                Toast.makeText(context, "Bookmark added", Toast.LENGTH_SHORT).show()
                binding.listItemBookmarked.setImageDrawable(context.getDrawable(R.drawable.star_filled))
            }
            homeViewModel.updateBookMark(movie.id)

        }


    }

}