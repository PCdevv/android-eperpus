package com.pcdevv.e_perpus.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pcdevv.e_perpus.models.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(book: Book): Long

    @Query("SELECT * FROM books")
    fun getAllBoks(): LiveData<List<Book>>

    @Delete
    suspend fun deleteBook(book: Book)
}