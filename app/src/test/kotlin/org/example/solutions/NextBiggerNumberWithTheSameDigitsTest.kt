package org.example.solutions

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class NextBiggerNumberWithTheSameDigitsTest {
    private val nextBiggerNumber = NextBiggerNumberWithTheSameDigits()::nextBiggerNumber

    @Test
    fun testBasic() {
        assertEquals(21, nextBiggerNumber(12))
        assertEquals(531, nextBiggerNumber(513))
        assertEquals(2071, nextBiggerNumber(2017))
        assertEquals(441, nextBiggerNumber(414))
        assertEquals(414, nextBiggerNumber(144))
    }

    @Test
    fun testComplex() {
        assertEquals(1210487444, nextBiggerNumber(1210484744))
        assertEquals(292821200, nextBiggerNumber(292821020))
        assertEquals(701304529, nextBiggerNumber(701304295))
        assertEquals(123456798, nextBiggerNumber(123456789))
        assertEquals(1234567908, nextBiggerNumber(1234567890))
        assertEquals(1907888999, nextBiggerNumber(1899998870))
    }
}