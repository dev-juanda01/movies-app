package com.example.moviesapp.fragments.useraccess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.moviesapp.R

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val toast = Toast.makeText(requireActivity(), "Inicio de sesión", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}