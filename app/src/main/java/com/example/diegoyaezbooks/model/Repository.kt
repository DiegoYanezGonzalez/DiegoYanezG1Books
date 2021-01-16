package com.example.diegoyaezbooks.model

import android.util.Log
import androidx.lifecycle.MutableLiveData

class Repository{

    val book : MutableLiveData<List<Books>> = MutableLiveData()

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

}