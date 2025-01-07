package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiophantineEquationTest {
    private val equation = DiophantineEquation()
    private val solEquaStr = equation::solEquaStr
    
    @Test
    fun test() {
        assertEquals("[[4, 1]]", solEquaStr(12))
        assertEquals("[[7, 3]]", solEquaStr(13))

        val a =
            "[[4505, 2252], [1503, 750], [647, 320], [505, 248], [415, 202], [353, 170], [225, 102], [153, 60], [135, 48], [103, 20], [97, 10], [95, 2]]"
        assertEquals(a, solEquaStr(9009))

        assertEquals("[]", solEquaStr(90002))
        assertEquals("[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]", solEquaStr(90005))

    }
}