package com.wiprotest.demo.api

import com.wiprotest.demo.model.PopuralAlbum
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndpointsInterface {
    @GET(".")
    fun getAlbum( @Query("method") key: String, @Query("album") album: String, @Query("format") format: String,@Query("api_key") method: String): Call<PopuralAlbum>

   /* companion object{
        fun create(url : String): EndpointsInterface {
            val retrofit = Retrofit.Builder()
                // here we set the base url of our API
                .baseUrl(url)
                // add the JSON dependency so we can handle json APIs
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            // here we pass a reference to our API interface
            // and get back a concrete instance
            return retrofit.create(EndpointsInterface::class.java)
        }
    }*/
  }