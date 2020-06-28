package com.wiprotest.demo

import com.wiprotest.demo.model.PopuralAlbum
import retrofit2.Response

interface UiView {
    fun viewData(apiResponse : Response<PopuralAlbum>)
    fun getScreenSize(screenInt : Int) : String
    fun viewError(resposeCode : Int)
}