package com.pcdevv.e_perpus.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pcdevv.e_perpus.models.Book

@Database(
    entities = [Book::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class BookDatabase : RoomDatabase() {
    abstract fun getBookDao(): BookDao

    companion object {
        @Volatile
        private var instance: BookDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BookDatabase::class.java,
                "book_db.db"
            ).build()
    }
}