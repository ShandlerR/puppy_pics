package com.example.dogimagesearch

import org.junit.Assert.assertEquals
import org.junit.Test

class DogImageSearchTest {

    @Test
    fun emptyTermSearch() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6),
            "Birds" to listOf(7,8,9,10)
        )

        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assertEquals(directory, result)
        //teardown
    }

    fun emptySpacesInEmptyTerm()
    {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6),
            "Birds" to listOf(7,8,9,10)
        )

        var searchTerm = "  "

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assertEquals(directory, result)
        //teardown
    }

    fun halfTermInDirectory_lowercase() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = "Do"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun halfTermInDirectory_capital() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = "Do"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun halfTermInDirectory_mixed() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = "Do"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun termNotInDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun fullTermInDirectory_lower() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun fullTermInDirectory_capital() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }


    fun fullTermInDirectory_mixed() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun extraLettersInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun extraLettersInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun singleSpaceInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun singleSpaceInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun singleSpaceInTerm_middle() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun doubleSpaceInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }
    fun doubleSpaceInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }
    fun doubleSpaceInTerm_middle() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun doubleSpaceInTerm_random() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }

    fun duplicateInDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify

        //teardown
    }
}