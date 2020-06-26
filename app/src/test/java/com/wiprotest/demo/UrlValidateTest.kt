package com.wiprotest.demo

import com.wiprotest.demo.util.Helper
import org.junit.Assert
import org.junit.Test

class UrlValidateTest {
    var helper= Helper()

    @Test
    fun validateBaseUrl(){
        Assert.assertNotNull(helper.BaseUrl())
    }


    @Test
    fun validUrl(){
        var response = helper.validURL()
        //print(response)
        Assert.assertNotNull(response)
    }
}