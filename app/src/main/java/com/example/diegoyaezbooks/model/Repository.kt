package com.example.diegoyaezbooks.model

import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.example.diegoyaezbooks.model.pojos.Books
import com.example.diegoyaezbooks.model.pojos.DetailBooks
import com.example.diegoyaezbooks.model.remote.RetrofitClient

class Repository{

    val book : MutableLiveData<List<Books>> = MutableLiveData()
    val bookDetail : MutableLiveData<DetailBooks> = MutableLiveData()

    suspend fun getBooksRepo() {
        Log.d("getCountries","TenemosDatos")
        val response = RetrofitClient.retrofitInstance().getBooks()

        if(response.isSuccessful) {
            response.body()?.let {
                Log.d("Books","tenemos ${it.size} paises")
                book.value= it
            }
        } else {
            Log.d("Error","${response.errorBody()}")
        }
    }

    suspend fun getBookDetails(code:Int){
        Log.d("DetailGet","Se muestran los datos de Detalles")
    val response = RetrofitClient.retrofitInstance().getBookDetail(code)

        when(response.isSuccessful){
            true ->response.body()?.let { bookDetail.value = it }
            false -> Log.d("ErrorDetail","No se muestran Los dettales del Libro")
        }

    }

}