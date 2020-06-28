package com.wiprotest.demo

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.wiprotest.demo.util.AlbumService
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApiResponseTest {
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    var mManiActivity: MainActivity? = null
    lateinit var albumService: AlbumService

    @Before
    fun setUp() {
        /*get the instance for activity*/
        mManiActivity = mActivityRule.activity
        albumService = AlbumService(mManiActivity!!)
    }

    @After
    fun tearDown() {
        mManiActivity = null /*do activity null at the end*/
    }

    @Test
    fun apiResponse() {
        val response = albumService.getApiCallResponse("all")
        Assert.assertNotNull(response)
    }

}