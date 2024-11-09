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
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assertEquals(directory, result)
        //teardown
    }

    @Test
    fun emptySpacesInEmptyTerm()
    {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6),
            "Birds" to listOf(7,8,9,10)
        )
        val searchTerm = "  "

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assertEquals(directory, result)
        //teardown
    }

    @Test
    fun halfTermInDirectory_lowercaseTerm_lowercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9,10)
        )
        val searchTerm = "ca"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "cats" to listOf(4,5,6)
        )
        assertEquals(result, expected)

        //teardown
    }

    @Test
    fun halfTermInDirectory_uppercaseTerm_lowercaseDirectory() {
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9,10)
        )
        val searchTerm = "CA"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "cats" to listOf(4,5,6)
        )
        assertEquals(result, expected)

        //teardown
    }

    @Test
    fun halfTermInDirectory_mixedCasingTerm_lowercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9,10)
        )
        val searchTerm = "cAt"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "cats" to listOf(4,5,6)
        )
        assertEquals(result, expected)
        //teardown
    }

    @Test
    fun halfTermInDirectory_lowercaseTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9,10)
        )
        val searchTerm = "ca"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "CATS" to listOf(4,5,6)
        )
        assertEquals(result, expected)
        //teardown
    }

    @Test
    fun halfTermInDirectory_uppercaseTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9,10)
        )
        val searchTerm = "CA"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "CATS" to listOf(4,5,6)
        )
        assertEquals(result, expected)

        //teardown
    }

    @Test
    fun halfTermInDirectory_mixedTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9,10)
        )
        val searchTerm = "cAt"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "CATS" to listOf(4,5,6)
        )
        assertEquals(result, expected)

        //teardown
    }

    @Test
    fun fullTermInDirectory_lowercaseTerm_lowercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9)
        )
        val searchTerm = "birds"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "birds" to listOf(7,8,9)
        )
        assertEquals(result, expected)
        //teardown
    }

    @Test
    fun fullTermInDirectory_uppercaseTerm_lowercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9)
        )
        val searchTerm = "DOGS"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3)
        )
        assertEquals(result, expected)
        //teardown
    }

    @Test
    fun fullTermInDirectory_mixedTerm_lowercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "dogs" to listOf(1,2,3),
            "cats" to listOf(4,5,6),
            "birds" to listOf(7,8,9)
        )
        val searchTerm = "bIrDs"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "birds" to listOf(7,8,9)
        )
        assertEquals(result, expected)
        //teardown
    }

    @Test
    fun fullTermInDirectory_lowercaseTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9,10)
        )
        val searchTerm = "cats"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        val expected: Map<String, List<Int>> = mapOf(
            "CATS" to listOf(4,5,6)
        )
        assertEquals(result, expected)
        //teardown
    }

    fun fullTermInDirectory_uppercaseTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9)
        )
        val searchTerm = "DOGS"

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }


    fun fullTermInDirectory_mixedTerm_uppercaseDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "DOGS" to listOf(1,2,3),
            "CATS" to listOf(4,5,6),
            "BIRDS" to listOf(7,8,9,10)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun termNotInDirectory() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun extraLettersInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun extraLettersInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun singleSpaceInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun singleSpaceInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun singleSpaceInTerm_middle() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun doubleSpaceInTerm_start() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }
    fun doubleSpaceInTerm_end() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }
    fun doubleSpaceInTerm_middle() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun doubleSpaceInTerm_random() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun multipleKeysShareSameValue() {
        //setup
        val directory: Map<String, List<Int>> = mapOf(
            "Dogs" to listOf(1,2,3),
            "Cats" to listOf(4,5,6)
        )
        val searchTerm = ""

        //exercise
        val result = findCloseInDirectory(searchTerm, directory)

        //verify
        assert(false)
        //teardown
    }

    fun oneTermMultipleKeys_lowercaseTerm_lowercaseDirectory() {

    }

    fun oneTermMultipleKeys_uppercaseTerm_lowercaseDirectory() {

    }

    fun oneTermMultipleKeys_lowercaseTerm_uppercaseDirectory() {

    }
}