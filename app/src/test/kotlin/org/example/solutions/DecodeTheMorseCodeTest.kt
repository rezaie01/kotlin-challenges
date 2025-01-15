package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecodeTheMorseCodeTest {

    @Test
    fun exampleTestCases() {
        assertEquals("HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. ."))
        assertEquals("HELLO, THERE!", decodeMorse(".... . .-.. .-.. --- --..--   - .... . .-. . -.-.--"))
    }
}