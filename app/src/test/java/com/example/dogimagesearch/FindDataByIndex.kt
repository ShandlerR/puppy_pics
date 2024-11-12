package com.example.dogimagesearch

import org.junit.Assert.assertEquals
import org.junit.Test

class FindDataByIndex {

    @Test
    fun findStartInFirstList() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,0)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("A", 5)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun findEndInFirstList() {
        //setup
        val index = 2
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,0)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("A", 10)
        assertEquals(expected, result)
        //teardown
    }

    fun findStartInSecondList() {
        //setup
        val index = 3
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,0)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("B", 19)
        assertEquals(expected, result)
        //teardown
    }
    fun findEndInSecondList() { }
    fun findEmptyResult_firstList() { }
    fun negativeIndex() { }
    fun overflowSearch() { }
    fun firstListEmpty() { }
    fun secondListEmpty_overflow() { }
    fun emptyMap() {
        // 5th position
    }
    fun bothEmptyLists() { }

    /*
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,0)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("", 0)
        assertEquals(expected, result)
        //teardown
     */
}