package com.kovalsikoski.johan.marvelapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.math.BigInteger
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()

    }

    private fun test(){
        val call = RetrofitInitializer().marvelService().getCharactersPage("v1/public/characters?ts=1526419169643&apikey=63c845f07f40335b0a40a3942bcc5ca8&hash=9ad4455630555fbb82024ab5d605dc55")

        call.enqueue(object : Callback<MarvelHeader> {
            override fun onResponse(call: Call<MarvelHeader>?, response: Response<MarvelHeader>?) {
                response?.body()?.data?.results?.let{
                    it.forEach {
                        Log.d("eoq", it.name)
                        println("=========================>${it.name}")
                    }
                }
            }

            override fun onFailure(call: Call<MarvelHeader>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        })
    }

    private fun md5(): String {

        val ts = Date().time
        val hash = "$ts${getString(R.string.private_key)}${getString(R.string.public_key)}"

        val messageDigest = MessageDigest.getInstance("MD5")
        messageDigest.update(hash.toByteArray(), 0, hash.length)

        return BigInteger(1, messageDigest.digest()).toString(16)

    }

        /*
            http://gateway.marvel.com/v1/public/characters?ts=1526419169643&apikey=63c845f07f40335b0a40a3942bcc5ca8&hash=9ad4455630555fbb82024ab5d605dc55
        */
}
