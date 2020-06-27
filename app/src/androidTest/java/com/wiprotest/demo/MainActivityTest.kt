package com.wiprotest.demo

import android.content.res.Configuration
import android.view.View
import androidx.test.runner.AndroidJUnit4
//import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.*

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/* Unit test for activity successfully launched or not */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    /* for activity test we need activity rule */
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    private lateinit var mManiActivity:  MainActivity
        @Before
        fun setUp() {
            /*get the instance for activity*/
            mManiActivity = mActivityRule.activity
        }
    @After
    fun tearDown() {

    }
    @Test
    fun launch(){
        val view : View = mManiActivity.linearLayout
        assertNotNull(view) /* if view is not null the activity is successfully launched */
    }

    @Test
    fun testScreen_SIZE_SMALL() {
        val screenSize = mManiActivity.getScreenSize(1)
        assertEquals("small", screenSize) /* if screen is small */
    }

    @Test
    fun testScreenSize_SIZE_MEDIUM() {
        val screenSize = mManiActivity.getScreenSize(2)
        assertEquals("medium",screenSize) /* if screen is medium */
    }
    @Test
    fun testScreenSize_SIZE_LARGE() {
        val screenSize = mManiActivity.getScreenSize(3)
        assertEquals("large",screenSize) /* if screen is large */
    }
    @Test
    fun testScreenSize_SIZE_XTRALARGE() {
        val screenSize = mManiActivity.getScreenSize(4)
        assertEquals("extralarge",screenSize) /* if is extra large */
    }
}