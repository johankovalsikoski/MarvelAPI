package com.kovalsikoski.johan.marvelapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val BASE_URL : String = "http://gateway.marvel.com/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun marvelService() = retrofit.create(MarvelService::class.java)
}