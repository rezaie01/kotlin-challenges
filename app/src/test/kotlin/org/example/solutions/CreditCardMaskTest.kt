package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CreditCardMaskTest {
    private val solution = CreditCardMask()::solve
    @Test
    fun testEmpty() {
        assertEquals("", solution(""))
    }

    @Test
    fun testLengthLessThan4() {
        assertEquals("123", solution("123"))
    }

    @Test
    fun testLengthGreaterThan4() {
        assertEquals("########d2eA", solution("SF&SDfgsd2eA"))
    }
}