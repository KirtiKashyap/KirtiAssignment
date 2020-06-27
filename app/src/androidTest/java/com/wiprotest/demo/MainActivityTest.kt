package com.wiprotest.demo

import android.view.View
import androidx.test.runner.AndroidJUnit4
//import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.*

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/* Unit test for activity successfully launced or not */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    /*for activity test we need activirt rule*/
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    lateinit var mManiActivity:  MainActivity
//    companion object {
        @Before
        fun setUp() {
            /*get the instance for activity*/
            mManiActivity = mActivityRule.activity
        }
//    }
@Test
fun launch(){
    val view : View =mManiActivity.linearLayout
    assertNotNull(view) // if view is not null the activity is successfully launched
}
    @After
    fun tearDown() {

    }
}