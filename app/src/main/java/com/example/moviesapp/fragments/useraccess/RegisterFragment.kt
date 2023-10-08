package com.example.moviesapp.fragments.useraccess

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moviesapp.R
import com.example.moviesapp.database.UserDB


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var editUsername: EditText
    private lateinit var editPassword: EditText
    private lateinit var editEmail: EditText
    private lateinit var editCountry: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.editUsername = view.findViewById(R.id.txt_username_register)
        this.editEmail = view.findViewById(R.id.txt_email_register)
        this.editPassword = view.findViewById(R.id.txt_password_register)
        this.editCountry = view.findViewById(R.id.txt_country_register)


        val btnRegister = view.findViewById<Button>(R.id.btn_register_second)

        btnRegister.setOnClickListener {
            val username = editUsername.getText().toString()
            val email = this.editEmail.getText().toString()
            val password = this.editPassword.getText().toString()
            val country = this.editCountry.getText().toString()

            if(!this.isCompleteDataField(username, email, password, country)) {
                Toast.makeText(requireActivity(), "Campos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                val userManager = UserDB(requireActivity())
                val resultInsertData = userManager.create(null, username, email, password, country)

                if(resultInsertData <= 0) {
                    Toast.makeText(requireActivity(), "No se puedo registrar", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireActivity(), "¡Registro exitoso!", Toast.LENGTH_SHORT).show()
                    this.clearField()
                }
            }
        }
    }

    private fun isCompleteDataField(username: String, password: String, email: String, country: String): Boolean {
        val completeData = username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && country.isNotEmpty()

        return  completeData
    }

     private fun clearField() {
         this.editUsername.setText("")
         this.editEmail.setText("")
         this.editPassword.setText("")
         this.editCountry.setText("")
     }
}
