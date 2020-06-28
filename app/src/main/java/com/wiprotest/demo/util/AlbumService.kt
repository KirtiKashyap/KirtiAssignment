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
        view = mainActivity
    }

    val request = ServiceBuilder.buildService(EndpointsInterface::class.java)
    fun getApiCallResponse(albumString: String) {
        val call = request.getAlbum(
            Constants.METHOD_NAME,
            albumString,
            Constants.FORMAT,
            Constants.API_KEY
        )
        call.enqueue(object : Callback<PopuralAlbum> {
            override fun onResponse(call: Call<PopuralAlbum>, response: Response<PopuralAlbum>) {
                if (response.isSuccessful) {
                    view.viewData(response)
                } else {
                    response.errorBody()
                    view.viewError(response.code())
                }
            }

            override fun onFailure(call: Call<PopuralAlbum>, t: Throwable) {

            }
        })
    }
}