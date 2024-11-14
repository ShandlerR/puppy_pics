package com.example.dogimagesearch

import org.junit.Assert.assertEquals
import org.junit.Test

class IsLastTest {

    @Test
    fun nameNotInList_imageNotInList() {
        //setup
        val nameAndImage = Pair("Bob", 2930)
        val directory = mapOf(
            "Cats" to listOf(1,2,3),
            "Dogs" to listOf(4,5,6)
        )
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(false, result)
        //teardown
    }

    @Test
    fun nameNotInList_imageInList() {
        //setup
        val nameAndImage = Pair("Bob", 5)
        val directory = mapOf(
            "Cats" to listOf(1,2,3),
            "Dogs" to listOf(4,5,6)
        )
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(false, result)
        //teardown
    }

    @Test
    fun nameInList_imageNotInList() {
        //setup
        val nameAndImage = Pair("Dogs", 2930)
        val directory = mapOf(
            "Cats" to listOf(1,2,3),
            "Dogs" to listOf(4,5,6)
        )
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(false, result)
        //teardown
    }

    @Test
    fun termExists_endFirstList() {
        //setup
        val nameAndImage = Pair("Cats", 3)
        val directory = mapOf(
            "Cats" to listOf(1,2,3),
            "Dogs" to listOf(4,5,6)
        )
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(false, result)
        //teardown
    }

    @Test
    fun termExists_endSecondList() {
        //setup
        val nameAndImage = Pair("Dogs", 6)
        val directory = mapOf(
            "Cats" to listOf(1,2,3),
            "Dogs" to listOf(4,5,6)
        )
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(true, result)
        //teardown
    }

    @Test
    fun empty_list() {
        //setup
        val nameAndImage = Pair("Cats", 2)
        val directory: Map<String, List<Int>> = mapOf()
        //exercise
        val result = isLastImage(nameAndImage, directory)
        //verify
        assertEquals(true, result)
        //teardown
    }
}