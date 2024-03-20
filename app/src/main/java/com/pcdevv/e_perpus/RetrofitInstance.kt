package com.pcdevv.e_perpus

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
object RetrofitInstance {
    val api: BookApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://840c-182-253-126-2.ngrok-free.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookApi::class.java)
    }
}