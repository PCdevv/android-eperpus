package com.pcdevv.e_perpus.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "books"
)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val id_buku: Int,
    val id_kategori: Int,
    val id_pengarang: Int,
    val id_subkategori: Int,
    val judul_buku: String,
    val kategori: Kategori,
    val pengarang: Pengarang,
    val subkategori: Subkategori
)