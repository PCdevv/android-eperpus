package com.pcdevv.e_perpus.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.pcdevv.e_perpus.models.Kategori
import com.pcdevv.e_perpus.models.Pengarang
import com.pcdevv.e_perpus.models.Subkategori

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromKategori(kategori: Kategori): String {
        return gson.toJson(kategori)
    }

    @TypeConverter
    fun toKategori(json: String): Kategori {
        return gson.fromJson(json, Kategori::class.java)
    }

    @TypeConverter
    fun fromPengarang(pengarang: Pengarang): String {
        return gson.toJson(pengarang)
    }

    @TypeConverter
    fun toPengarang(json: String): Pengarang {
        return gson.fromJson(json, Pengarang::class.java)
    }

    @TypeConverter
    fun fromSubkategori(subkategori: Subkategori): String {
        return gson.toJson(subkategori)
    }

    @TypeConverter
    fun toSubkategori(json: String): Subkategori {
        return gson.fromJson(json, Subkategori::class.java)
    }
//    @TypeConverter
//    fun fromKategori(kategori: Kategori): String {
//        return kategori.nama_kategori
//    }
//
//    @TypeConverter
//    fun toKategori(nama_kategori: String): Kategori {
//        return Kategori(nama_kategori, nama_kategori)
//    }
}