package com.example.moviesapp.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.api.Endpoints
import com.example.moviesapp.databinding.ItemMovieBinding
import com.example.moviesapp.models.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)
    private val endpoints = Endpoints()

    fun bind(movie: Movie) {
        val URL_IMAGE = "${endpoints.URL_IMAGES_SERVICE}${movie.getPosterPath()}"

        Picasso.get().load(URL_IMAGE).into(binding.imgPoster)
    }
}