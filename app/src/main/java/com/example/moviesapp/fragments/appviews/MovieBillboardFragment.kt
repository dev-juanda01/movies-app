package com.example.moviesapp.fragments.appviews

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.adapters.MovieAdapter
import com.example.moviesapp.api.APIClient
import com.example.moviesapp.api.IAPIMovie
import com.example.moviesapp.databinding.FragmentMovieBillboardBinding
import com.example.moviesapp.models.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieBillboardFragment : Fragment(R.layout.fragment_movie_billboard) {
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentMovieBillboardBinding

    private val moviesBillboard = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMovieBillboardBinding.inflate(layoutInflater)
        requireActivity().setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        movieAdapter = MovieAdapter(moviesBillboard)

        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewMovies.layoutManager = GridLayoutManager(requireActivity(), 2)

        binding.recyclerViewMovies.adapter = movieAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.showMovies()
    }

    override fun onStart() {
        super.onStart()

        this.showMovies()
    }

    private fun showMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = APIClient.getClient().create(IAPIMovie::class.java)
                .getMovies(APIClient.endpoints.URL_EXTRA)

            val moviesData = call.body()

            requireActivity().runOnUiThread {
                if (call.isSuccessful) {
                    val moviesAll = moviesData?.movies ?: emptyList<Movie>()

                    moviesBillboard.clear()
                    moviesBillboard.addAll(moviesAll)
                    movieAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireActivity(), "Error al cargar peliculas", Toast.LENGTH_SHORT)
            .show()
    }
}