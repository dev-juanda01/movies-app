package com.example.moviesapp.models

class Movie() {
    private var id: Int? = null
    private var adult: Boolean? = null
    private var backdrop_path: String? = null
    private var genre_ids: Array<Int>? = null
    private var original_language: String? = null
    private var original_title: String? = null
    private var overview: String? = null
    private var popularity: Float? = null
    private var poster_path: String? = null
    private var release_date: String? = null
    private var title: String? = null
    private var video: Boolean? = null
    private var vote_average: Float? = null
    private var vote_count: Int? = null

    fun getId(): Int? = this.id
    fun setId(id: Int?) { this.id = id }

    fun getAdult(): Boolean? = this.adult
    fun setAdult(adult: Boolean?) { this.adult = adult }

    fun getTitle(): String? = this.title
    fun setTitle(title: String?) { this.title = title }
    
    fun getPosterPath(): String? = this.poster_path
    fun setPosterPath(poster_path: String?) { this.poster_path = poster_path }
}