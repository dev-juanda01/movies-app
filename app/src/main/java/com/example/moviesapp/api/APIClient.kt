package com.example.moviesapp.api

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {
        val endpoints = Endpoints()

        fun getClient(): Retrofit {
            return Retrofit.Builder().baseUrl(endpoints.BASE_URL_SERVICE).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}