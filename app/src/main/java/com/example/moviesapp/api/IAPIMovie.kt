package com.example.moviesapp.api

import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IAPIMovie {

    @GET
    suspend fun getMovies(@Url url: String): Response<MovieResponse>
}