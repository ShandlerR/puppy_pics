package com.example.dogimagesearch

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyPress
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
    fun noSearch_start() {
        //setup
        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }
        //exercise
        //verify
        composeTestRule.onNodeWithText("Khaleesi")
            .assertExists("No Node with the name 'Khaleesi' was found")
        composeTestRule.onNodeWithTag("back")
            .assertIsNotEnabled()
        composeTestRule.onNodeWithTag("front")
            .assertIsEnabled()
        //teardown
    }

    @Test
    fun singleNextPress() {
        //setup
        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }
        //exercise
        composeTestRule.onNodeWithTag("front")
            .performClick()
        //verify
        composeTestRule.onNodeWithText("Khaleesi")
            .assertExists("No Node with the name 'Khaleesi' was found")
        composeTestRule.onNodeWithTag("back")
            .assertIsEnabled()
        composeTestRule.onNodeWithTag("front")
            .assertIsEnabled()
        //teardown
    }

    @Test
    fun noSearch_end() {
        //setup
        val directory = mapOf(
            "khaleesi" to listOf(
                R.drawable.kahlsee0,
                R.drawable.kahlsee2
            )
        )

        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }

        //exercise
        composeTestRule.onNodeWithTag("front")
            .performClick()
        //verify
        composeTestRule.onNodeWithText("Khaleesi")
            .assertExists("No Node with the name 'Khaleesi' was found")
        composeTestRule.onNodeWithTag("back")
            .assertIsEnabled()
        composeTestRule.onNodeWithTag("front")
            .assertIsNotEnabled()
        //teardown
    }

    fun halfTermSearch_start() {
        //setup
        val textInput = "Qub"
        composeTestRule.setContent {
            DogImageSearchTheme {
                DogImageSearch(directory)
            }
        }
        //exercise
        composeTestRule.onNodeWithText("Find a Puppy")
            .performTextInput(textInput)
        //verify
        composeTestRule.onNodeWithText("Qubert")
            .assertExists("No Node with the name '$textInput' was found")
        composeTestRule.onNodeWithTag("back")
            .assertIsNotEnabled()
        composeTestRule.onNodeWithTag("front")
            .assertIsEnabled()
        //teardown
    }

    fun halfTermSearch_end() { }

    fun weirdSpaces() { }

    fun noRelatedDog_filledDictionary() { }

    fun emptyDictionaryResult() { }

    fun noNameDogInDirectory() { }

}