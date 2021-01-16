package com.example.diegoyaezbooks.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
class RetrofitClient {
    companion object {
        fun retrofitInstance(): BooksApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(BooksApi::class.java)
        }
    }
}