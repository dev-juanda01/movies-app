package com.example.moviesapp.database

interface IOperationDB {
    fun create(name: String?, username: String, email: String, password: String, country: String): Long

    fun read(usernameLogin: String, passwordLogin: String): Boolean
}