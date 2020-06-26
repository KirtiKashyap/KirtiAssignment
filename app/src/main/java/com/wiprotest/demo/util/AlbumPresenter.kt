package com.wiprotest.demo.util

import com.wiprotest.demo.MainActivity
import com.wiprotest.demo.model.PopuralAlbum
import retrofit2.Response

class AlbumPresenter(mainActivity: MainActivity, albumService: AlbumService) {
     var view: MainActivity
     var service: AlbumService
    init {
        view=mainActivity
        service=albumService
    }
    fun getAlbum(album: String): Response<PopuralAlbum>? {
        val apiResponse: Response<PopuralAlbum>? = service.getApiCallResponse(album)
        if (apiResponse!=null && apiResponse.isSuccessful) {
        }
        return apiResponse
    }
}