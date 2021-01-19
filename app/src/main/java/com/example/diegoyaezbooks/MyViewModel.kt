package com.example.diegoyaezbooks

import android.util.Log
import androidx.lifecycle.*
import com.example.diegoyaezbooks.model.Repository
import com.example.diegoyaezbooks.model.mapperBookDataToApi
import com.example.diegoyaezbooks.model.pojos.Books
import com.example.diegoyaezbooks.model.pojos.DetailBooks
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val repository = Repository()
    private val booksVMMap = Transformations.map(repository.booksRepo){
        entities -> entities.map { mapperBookDataToApi(it) }
    }

    private val selected =MutableLiveData<Books>()


    fun getDetail() : LiveData<DetailBooks> = repository.bookDetail

    init {
        Log.d("ViewModelDatos","cargando la información de los li")
        viewModelScope.launch {
            repository.getBooksRepo()
        }
    }

    fun booksVM():LiveData<List<Books>> = booksVMMap

    fun selected():LiveData<Books> = selected

    fun selected(books: Books){
        selected.value=books
        viewModelScope.launch {
           repository.getBookDetails(books.id)
        }
    }
}