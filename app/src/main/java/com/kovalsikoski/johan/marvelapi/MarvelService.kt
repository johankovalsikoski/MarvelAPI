package com.kovalsikoski.johan.marvelapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MarvelService {

    @GET
//    @GET("v1/public/characters?ts=1526419169643&apikey=63c845f07f40335b0a40a3942bcc5ca8&hash=9ad4455630555fbb82024ab5d605dc55")
    fun getCharactersPage(@Url url: String): Call<MarvelModel>

}