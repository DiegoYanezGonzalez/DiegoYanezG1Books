package com.example.diegoyaezbooks.model.remote

import com.example.diegoyaezbooks.model.pojos.Books
import com.example.diegoyaezbooks.model.pojos.DetailBooks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.StringBuilder

interface BooksApi {

    @GET("books")
    suspend fun getBooks() : Response<List<Books>>

    @GET("booksDetail/{code}")
    suspend fun getBookDetail(@Path("code")code:String):Response<DetailBooks>
}