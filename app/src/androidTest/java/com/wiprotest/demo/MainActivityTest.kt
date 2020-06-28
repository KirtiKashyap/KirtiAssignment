package com.wiprotest.demo

import android.app.Instrumentation.ActivityMonitor
import android.view.View
import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.wiprotest.demo.ui.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/* Unit test for activity successfully launched or not */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    /* for activity test we need activity rule */
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    var mManiActivity:  MainActivity?=null
    var activityMonitor: ActivityMonitor = getInstrumentation().addMonitor(
        DetailActivity::class.java.getName(), null, false)
        @Before
        fun setUp() {
            /*get the instance for activity*/
            mManiActivity = mActivityRule.activity
        }
    @After
    fun tearDown() {
        mManiActivity=null /*do activity null at the end*/
    }
    @Test
    fun launch(){
        val view : View = mManiActivity!!.linearLayout
        assertNotNull(view) /* if view is not null the activity is successfully launched */
    }

    @Test
    fun testScreen_SIZE_SMALL() {
        val screenSize = mManiActivity!!.getScreenSize(1)
        assertEquals("small", screenSize) /* if screen is small */
    }

    @Test
    fun testScreenSize_SIZE_MEDIUM() {
        val screenSize = mManiActivity!!.getScreenSize(2)
        assertEquals("medium",screenSize) /* if screen is medium */
    }
    @Test
    fun testScreenSize_SIZE_LARGE() {
        val screenSize = mManiActivity!!.getScreenSize(3)
        assertEquals("large",screenSize) /* if screen is large */
    }
    @Test
    fun testScreenSize_SIZE_XTRALARGE() {
        val screenSize = mManiActivity!!.getScreenSize(4)
        assertEquals("extralarge",screenSize) /* if screen is extra large */
    }

}