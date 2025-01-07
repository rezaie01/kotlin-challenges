package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EncodeRomanTest {
    private val encode = EncodeRoman()::encode
    
    @Test
    fun testEncode() {
        assertEquals("", encode(0))
        assertEquals("I", encode(1))
        assertEquals("XXI", encode(21))
        assertEquals("MMVIII", encode(2008))
        assertEquals("MDCLXVI", encode(1666))
    }
}