package com.pcdevv.e_perpus.repository

import com.pcdevv.e_perpus.api.RetrofitInstance
import com.pcdevv.e_perpus.db.BookDatabase

class BookRepository(
    val db: BookDatabase
) {
    suspend fun getBooks() = RetrofitInstance.api.getBooks()
}