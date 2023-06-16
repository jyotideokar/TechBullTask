package com.example.techbullassignment.activity

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.techbullassignment.adapter.MovieAdapter
import com.example.techbullassignment.databinding.ActivityMainBinding
import com.example.techbullassignment.model.Search
import com.example.techbullassignment.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter
    private val data = ArrayList<Search>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.movieListLiveData.observe(this, Observer {
            data.addAll(it.Search)
            movieAdapter = MovieAdapter(data)
            binding.movieRecyclerView.adapter = movieAdapter
        })
        viewModel.loadMovieList("BatMan", "d9b7be32")

        binding.searchBoxContainer.searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                data.clear()
                movieAdapter?.notifyDataSetChanged()
                viewModel.loadMovieList(
                    binding.searchBoxContainer.searchEditText.text.toString(),
                    "d9b7be32"
                )
                true
            }
            false
        }
    }
}