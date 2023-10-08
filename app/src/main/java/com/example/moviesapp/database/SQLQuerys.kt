package com.example.moviesapp.database

class SQLQuerys {
    companion object {
        val CREATE_TABLE = "CREATE TABLE ${AccessDBHelper.DATABASE_TABLE_USERS} (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR," +
                "username VARCHAR NOT NULL," +
                "email VARCHAR NOT NULL," +
                "password VARCHAR NOT NULL," +
                "country VARCHAR NOT NULL)"

        val DROP_TABLE = "DROP TABLE ${AccessDBHelper.DATABASE_TABLE_USERS}"

        val READ_REGISTER = "SELECT * FROM ${AccessDBHelper.DATABASE_TABLE_USERS} WHERE"
    }
}
