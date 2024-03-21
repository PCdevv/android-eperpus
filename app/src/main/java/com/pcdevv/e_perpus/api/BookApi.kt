package com.pcdevv.e_perpus.api

import com.pcdevv.e_perpus.models.BookResponse
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {

    @GET("buku")
//    @GET("/todos")
    suspend fun getBooks(): Response<BookResponse>
//    data class BookResponse(
//        val data: List<Book>
//    )

//    @POST("/buku")
//    fun createBooks(@Body book: Book): Response<CreateBookResponse>
}