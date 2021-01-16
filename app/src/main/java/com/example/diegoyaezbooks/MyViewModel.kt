package com.example.diegoyaezbooks

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diegoyaezbooks.model.Repository
import com.example.diegoyaezbooks.model.pojos.Books
import com.example.diegoyaezbooks.model.pojos.DetailBooks
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val repository = Repository()

    private val booksView = repository.book

    private val selected= MutableLiveData<Books>()

   fun getDetail() : LiveData<DetailBooks> = repository.bookDetail

    init {
        Log.d("ViewModelDatos","cargando la información de los paises")
        viewModelScope.launch {
            repository.getBooksRepo()
        }
    }


    fun books() : LiveData<List<Books>> = booksView

    fun selected() : LiveData<Books> = selected

    fun selected(books: Books){
        selected.value=books

        viewModelScope.launch {
           repository.getBookDetails(books.id)
        }
    }

}