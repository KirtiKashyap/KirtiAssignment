package com.wiprotest.demo.util

import com.wiprotest.demo.MainActivity
import com.wiprotest.demo.api.ServiceBuilder
import com.wiprotest.demo.api.EndpointsInterface
import com.wiprotest.demo.model.PopuralAlbum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumService(mainActivity: MainActivity) {
       var view: MainActivity
init {
    view=mainActivity
}
    val request= ServiceBuilder.buildService(EndpointsInterface::class.java)
    fun getApiCallResponse(albumString: String): Response<PopuralAlbum>? {
        var responseData :Response<PopuralAlbum>?=null
        val call = request.getAlbum(Constants.METHOD_NAME,albumString,Constants.FORMAT,Constants.API_KEY)
        call.enqueue(object : Callback<PopuralAlbum> {
            override fun onResponse(call: Call<PopuralAlbum>, response: Response<PopuralAlbum>) {
                if (response.isSuccessful){
                    responseData=response
                    view.startMainActivity(responseData!!)
                }else{
                    response.errorBody()
                }
            }
            override fun onFailure(call: Call<PopuralAlbum>, t: Throwable) {
                responseData=null
            }
        })
        return responseData
    }
}