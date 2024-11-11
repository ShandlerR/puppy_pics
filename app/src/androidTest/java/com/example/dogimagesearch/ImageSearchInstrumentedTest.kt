package com.example.dogimagesearch

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.dogimagesearch.ui.theme.DogImageSearchTheme
import org.junit.Rule
import org.junit.Test

class ImageSearchInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val directory = mapOf(
        "khaleesi" to listOf(
            R.drawable.kahlsee0,
            R.drawable.kahlsee1,
            R.drawable.kahlsee2,
            R.drawable.kahlsee3
        ),
        "qubert" to listOf(
            R.drawable.qbert0,
            R.drawable.qbert1
        )
    )

    // Cover the big stuff

    @Test
    fun noSearch() {
        //setup
        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }
        //exercise
        //verify
        composeTestRule.onNodeWithText("Khaleesi")
            .assertExists("No Node with this text was found")
        //teardown
    }

    @Test
    fun halfTermSearch() {
        //setup
        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }
        //exercise
        composeTestRule.onNodeWithText("Find a Puppy")
            .performTextInput("Qub")
        //verify
        composeTestRule.onNodeWithText("Qubert")
            .assertExists("No Node with this text was found")
        //teardown
    }

    fun fullTermSearch() {
        //setup

        //exercise

        //verify

        //teardown
    }

    fun nextButton_start() {
        //setup

        //exercise

        //verify

        //teardown
    }

    fun nextButton_end() {
        //setup

        //exercise

        //verify

        //teardown
    }

    fun previousButton_mid() {
        //setup

        //exercise

        //verify

        //teardown
    }

    fun previousButton_start() {
        //setup

        //exercise

        //verify

        //teardown
    }

    fun noResultImageSearch() {
        //setup

        //exercise

        //verify

        //teardown
    }
}