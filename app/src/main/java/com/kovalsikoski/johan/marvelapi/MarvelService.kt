package com.kovalsikoski.johan.marvelapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/characters")
    fun getCharactersFirstPage(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String): Call<MarvelModel>

    @GET("v1/public/characters")
    fun getCharactersNextPage(
            @Query("ts") ts: String,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("offset") offset: Int): Call<MarvelModel>
}