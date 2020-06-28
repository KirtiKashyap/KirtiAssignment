package com.wiprotest.demo.util

import com.wiprotest.demo.api.EndpointsInterface
import com.wiprotest.demo.api.ServiceBuilder
import okhttp3.*
import java.io.IOException


class Helper {
    var baseUrl = "http://ws.audioscrobbler.com/2.0/"

    var url =
        "http://ws.audioscrobbler.com/2.0/?method=album.search&album=all&format=json&api_key=a3b60363766886905753f104b589e8aa"

    fun validURL(): String? {
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        val result: String? = client.newCall(request).execute().toString()
        return result
    }

    fun APICall(): String? {
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        var body: String? = null

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                body = response.body?.string()
            }

        })
        return body
    }

    fun BaseUrl(): Any? {
        return baseUrl
    }


}