package com.example.moviesapp.database

import android.content.ContentValues
import android.content.Context
import android.util.Log

class UserDB(context: Context?) : AccessDBHelper(context), IOperationDB {
    private val context = context

    override fun create(
        name: String?,
        username: String,
        email: String,
        password: String,
        country: String
    ): Long {
        var id: Long = 0

        try {
            val helper = AccessDBHelper(this.context)
            val dbManager = helper.getWritableDatabase()
            val valuesToInsert = ContentValues()

            valuesToInsert.put("name", name)
            valuesToInsert.put("username", username)
            valuesToInsert.put("email", email)
            valuesToInsert.put("password", password)
            valuesToInsert.put("country", country)

            id = dbManager.insert(DATABASE_TABLE_USERS, null, valuesToInsert)
            
            dbManager.close()
        } catch (ex: Exception) {
            ex.toString()
        }

        return id
    }

    override fun read(usernameLogin: String, passwordLogin: String): Boolean {
        var userValid = false

        try {
            val dbHelper = AccessDBHelper(this.context)
            val dbManager = dbHelper.getWritableDatabase()

            val userLogin = dbManager.rawQuery(
                "${SQLQuerys.READ_REGISTER} username='${usernameLogin}' AND password='${passwordLogin}' LIMIT 1",
                null
            )

            Log.d("Read User", userLogin.toString())

            userValid = userLogin.moveToFirst()

            userLogin.close()
        } catch (ex: Exception) {
            ex.toString()
        }

        return userValid
    }
}