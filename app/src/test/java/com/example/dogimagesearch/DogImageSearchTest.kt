package com.example.dogimagesearch

import org.junit.Test
import org.junit.Assert.*

class DogImageSearchTest {

    @Test
    fun emptyTermSearch() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        var searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assertEquals(searchTerm, "")
        assertEquals(result, listOf(1,2,3,4,5,6))

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