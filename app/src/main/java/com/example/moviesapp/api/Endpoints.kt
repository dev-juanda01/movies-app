package com.example.moviesapp.api

data class Endpoints(
    val BASE_URL_SERVICE: String = "https://api.themoviedb.org/3/discover/",
    val URL_IMAGES_SERVICE: String = "https://image.tmdb.org/t/p/w1280",
    val URL_EXTRA: String = "movie?api_key=ea27c41cbd532d19174d71429927e158&language=es&sort_by=popularity.desc&page=1"
)
