package com.wiprotest.demo.util

import android.widget.Toast
import com.wiprotest.demo.MainActivity
import com.wiprotest.demo.R
import com.wiprotest.demo.api.ServiceBuilder
import com.wiprotest.demo.api.EndpointsInterface
import com.wiprotest.demo.model.PopuralAlbum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumService(mainActivity: MainActivity) {
    var context: MainActivity
    init {
        context=mainActivity
    }
    val request= ServiceBuilder.buildService(EndpointsInterface::class.java)
    fun getApiCallResponse(albumString: String): Response<PopuralAlbum>? {
        var responseData :Response<PopuralAlbum>?=null
        val call = request.getAlbum(context.getString(R.string.method),albumString,context.getString(
            R.string.format
        ),context.getString(R.string.api_key))
        call.enqueue(object : Callback<PopuralAlbum> {
            override fun onResponse(call: Call<PopuralAlbum>, response: Response<PopuralAlbum>) {
                if (response.isSuccessful){
                    responseData=response
                    context.startMainActivity(response)
                }
            }
            override fun onFailure(call: Call<PopuralAlbum>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
        return responseData
    }
}