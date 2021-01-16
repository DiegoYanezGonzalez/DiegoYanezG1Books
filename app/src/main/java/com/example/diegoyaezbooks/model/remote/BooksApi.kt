package com.example.diegoyaezbooks.model.remote

import com.example.diegoyaezbooks.model.pojos.Books
import com.example.diegoyaezbooks.model.pojos.DetailBooks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {

    @GET("bookS")
    suspend fun getBooks() : Response<List<Books>>

    @GET("bookDetail/{code}")
    suspend fun getBookDetail(@Path("code")code:Int):Response<DetailBooks>
}