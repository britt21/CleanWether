package com.mobile.wethercompose

import androidx.compose.ui.test.*
import com.mobile.wethercompose.screens.HomeScreen
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    fun shouldEnableSearchButton(city: String): Boolean = city.isNotBlank()
    fun isFavoriteCity(favorite: String?, current: String): Boolean = favorite == current && favorite != null

    @Test
    fun testShouldEnableSearchButton() {
        assertTrue(shouldEnableSearchButton("London"))
        assertFalse(shouldEnableSearchButton(""))
    }
    @Test
    fun testIsFavoriteCity() {
        assertTrue(isFavoriteCity("London", "London"))
        assertFalse(isFavoriteCity(null, "London"))
        assertFalse(isFavoriteCity("Paris", "London"))
    }

}
