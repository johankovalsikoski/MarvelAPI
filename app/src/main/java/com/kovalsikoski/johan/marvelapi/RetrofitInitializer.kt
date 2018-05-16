package com.kovalsikoski.johan.marvelapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun marvelService() = retrofit.create(MarvelService::class.java)!!
}