package com.example.dogimagesearch

import android.util.Log
import org.junit.Assert.assertEquals
import org.junit.Test

class FindDataByIndex {

    @Test
    fun findStartInFirstList() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(1,2,3),
            "B" to listOf(4,5,6)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("A", 1)
        assertEquals(expected, result)
        //teardown
    }
    fun findEndInFirstList() { }
    fun findStartInSecondList() { }
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
            "A" to listOf(1,2,3),
            "B" to listOf(4,5,6)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("", 0)
        assertEquals(expected, result)
        //teardown
     */
}