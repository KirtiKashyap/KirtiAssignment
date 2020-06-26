package com.wiprotest.demo

import com.wiprotest.demo.model.PopuralAlbum
import retrofit2.Response

interface UiView {
    fun startMainActivity(apiResponse : Response<PopuralAlbum>)
}