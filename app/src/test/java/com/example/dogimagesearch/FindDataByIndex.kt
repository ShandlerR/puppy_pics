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

    @Test
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

    @Test
    fun findEndInSecondList() {
        //setup
        val index = 5
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("B", 2)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun findEmptyName_firstList() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "" to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 5)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun findEmptyNameSpaces_firstList() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "  " to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 5)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun negativeIndex() {
        //setup
        val index = -5
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("A", 5)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun overflowSearch() {
        //setup
        val index = 10
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("B", 2)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun firstListEmpty_start() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("B", 19)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun firstListEmpty_overflow() {
        //setup
        val index = 10
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("B", 2)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun secondListEmpty_overflow() {
        //setup
        val index = 7
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf()
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("A", 10)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun middleListEmpty_safeSkip() {
        //setup
        val index = 4
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(),
            "C" to listOf(5,2,4)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("C", 2)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun middleListEmpty_barelySkipped() {
        //setup
        val index = 3
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(),
            "C" to listOf(5,2,4)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("C", 5)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun emptyMap() {
        //setup
        val index = 5
        val directory: Map<String, List<Int>> = mapOf()

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2001))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 2001)
        assertEquals(expected, result)
        //teardown
        // 5th position
    }

    @Test
    fun bothEmptyLists_start() {
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(),
            "B" to listOf()
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2001))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 2001)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun bothEmptyLists_negative() {
        //setup
        val index = -1
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(),
            "B" to listOf()
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2001))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 2001)
        assertEquals(expected, result)
        //teardown
    }

    @Test
    fun bothEmptyLists_overflow() {
        //setup
        val index = 5
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(),
            "B" to listOf()
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory, Pair("Random Dog", 2001))

        //verify
        val expected: Pair<String, Int> = Pair("Random Dog", 2001)
        assertEquals(expected, result)
        //teardown
    }
    /*
        //setup
        val index = 0
        val directory: Map<String, List<Int>> = mapOf(
            "A" to listOf(5,7,10),
            "B" to listOf(19,14,2)
        )

        //exercise
        val result = findNameAndImageByIndex(index, directory)

        //verify
        val expected: Pair<String, Int> = Pair("", 0)
        assertEquals(expected, result)
        //teardown
     */
}