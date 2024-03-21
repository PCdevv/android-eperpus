package com.pcdevv.e_perpus.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object RetrofitInstance {
//    val api: BookApi by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(BookApi::class.java)
//    }
//}
class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl("https://8201-182-253-126-4.ngrok-free.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api: BookApi by  lazy {
            retrofit.create(BookApi::class.java)
        }
    }
}