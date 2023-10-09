package com.example.moviesapp.models

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") var pageCurrent: Int,
    @SerializedName("results") var movies: List<Movie>,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("total_results") var totalMovies: Int
)
