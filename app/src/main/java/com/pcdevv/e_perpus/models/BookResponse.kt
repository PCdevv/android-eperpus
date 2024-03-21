package com.pcdevv.e_perpus.models

//data class Book(
//    val id_buku: Int,
//    val id_kategori: Int,
//    val id_pengarang: Int,
//    val id_subkategori: Int,
//    val judul_buku: String
//)

data class BookResponse(
    val code: Int,
    val `data`: List<Book>,
    val message: String,
    val success: Boolean
)
