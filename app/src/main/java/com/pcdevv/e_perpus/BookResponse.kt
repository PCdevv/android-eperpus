package com.pcdevv.e_perpus

//data class Book(
//    val id_buku: Int,
//    val id_kategori: Int,
//    val id_pengarang: Int,
//    val id_subkategori: Int,
//    val judul_buku: String
//)

data class BookResponse(
    val code: Int,
    val `data`: List<Data>,
    val message: String,
    val success: Boolean
)

data class Data(
    val id_buku: Int,
    val id_kategori: Int,
    val id_pengarang: Int,
    val id_subkategori: Int,
    val judul_buku: String,
    val kategori: Kategori,
    val pengarang: Pengarang,
    val subkategori: Subkategori,
    val ulasan: List<Any>
)

data class Kategori(
    val id_kategori: Int,
    val nama_kategori: String
)

data class Pengarang(
    val id_pengarang: Int,
    val nama_pengarang: String
)

data class Subkategori(
    val id_kategori: Int,
    val id_subkategori: Int,
    val nama_subkategori: String
)