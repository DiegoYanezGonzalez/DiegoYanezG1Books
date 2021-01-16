package com.example.diegoyaezbooks.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val repository = Repository()

    private val booksView = repository.book

    init {
        Log.d("ViewModelDatos","cargando la información de los paises")
        viewModelScope.launch {
            repository.getBooksRepo()
        }
    }

    fun DoSomrething(){}

    fun books() : LiveData<List<Books>> = booksView

}