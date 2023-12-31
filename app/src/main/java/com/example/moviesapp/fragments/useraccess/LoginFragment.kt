package com.example.moviesapp.fragments.useraccess

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.database.UserDB

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var username: String = ""
    private var password: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editUsername = view.findViewById<EditText>(R.id.txt_username)
        val editPassword = view.findViewById<EditText>(R.id.txt_password)
        val btnLogin = view.findViewById<Button>(R.id.btn_login_main)

        btnLogin.setOnClickListener {
            this.password = editUsername.getText().toString()
            this.username = editPassword.getText().toString()

            if(this.isValidFields(this.username, this.password)) {
                // TODO: Validar usuario
                val userManager = UserDB(requireActivity())
                val userValidToLogin = userManager.read(this.username, this.password)

                Log.d("Usuario valido", userValidToLogin.toString())

                if(userValidToLogin) {
                    // TODO: enviar a otro fragmento
                    findNavController().navigate(R.id.action_loginFragment_to_movieBillboardFragment)
                } else {
                    Toast.makeText(requireActivity(), "Usuario no valido", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireActivity(), "Campos incompletos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidFields(usernameField: String, passwordField: String): Boolean {
        val isValid = usernameField.isNotEmpty() && passwordField.isNotEmpty();
        return isValid;
    }
}