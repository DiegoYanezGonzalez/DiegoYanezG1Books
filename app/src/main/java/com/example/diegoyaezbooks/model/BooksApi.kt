package com.example.diegoyaezbooks.model

import retrofit2.Response
import retrofit2.http.GET

interface BooksApi {

    @GET("books")
    suspend fun getBooks() : Response<List<Books>>
}