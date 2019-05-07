package com.sam43.performancetesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    private val username = "sam43"
    private val userPassword = "sam43000"
    private lateinit var stringToBetyped: String
    private var hello = "Hello World!"

    @Rule
    @JvmField
    val rule  = ActivityTestRule(MainActivity::class.java)

/*
    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso"
    }
*/

    @Test
    fun MainActivityTest() {
        Espresso.onView(withId(R.id.tvTest)).check(matches(withText(hello)))
        Espresso.onView(withId(R.id.btnNext)).perform(ViewActions.click())
        //Espresso.onView(withId(R.id.btnNext)).check(matches(withId(R.layout.activity_second)))
        Espresso.onView(withId(R.id.llSecond)).check(matches(isDisplayed()))
        //isViewIdGenerated(R.layout.activity_second)
    }
    //Login test
    @Test
    fun loggedInSuccess() {
        Espresso.onView(withId(R.id.etUsername)).perform(ViewActions.typeText(username))
        Espresso.onView(withId(R.id.etPassword)).perform(ViewActions.typeText(userPassword))
    }
}