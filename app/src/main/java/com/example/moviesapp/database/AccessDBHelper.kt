package com.example.moviesapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class AccessDBHelper(
    context: Context?,
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(manager: SQLiteDatabase?) {
        manager?.execSQL(SQLQuerys.CREATE_TABLE)
    }

    override fun onUpgrade(manager: SQLiteDatabase?, p1: Int, p2: Int) {
        // manager?.execSQL(SQLQuerys.DROP_TABLE)
        onCreate(manager)
    }

    companion object {
        val DATABASE_VERSION = 3;
        val DATABASE_NAME = "movies.db";
        val DATABASE_TABLE_USERS = "users";
    }
}