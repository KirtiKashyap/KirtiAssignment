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
  }