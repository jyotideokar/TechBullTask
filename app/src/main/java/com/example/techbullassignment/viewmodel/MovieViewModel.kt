package com.example.techbullassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.techbullassignment.model.Root
import com.example.techbullassignment.repository.MovieListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    val movieListLiveData = MutableLiveData<Root>()
    private var repository: MovieListRepository = MovieListRepository

    fun loadMovieList(movieName: String, apiKey: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val fetchedContacts = repository.getMovieList(movieName, apiKey)
            movieListLiveData.postValue(fetchedContacts.body())
        }
    }
}