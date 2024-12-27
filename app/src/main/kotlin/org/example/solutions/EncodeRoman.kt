package org.example.solutions

import org.example.utils.assertEquals

class EncodeRoman {
    fun encode(num: Int): String {
        return ("M".repeat(num / 1000)) + putSymbol(
            (num / 100) % 10,
            "C", "D", "M"
        ) + putSymbol((num % 100) / 10, "X", "L", "C") + putSymbol(num % 10, "I","V","X")
    }

    fun putSymbol(num: Int, sm: String, md: String, end: String): String = if (num <= 3) {
        sm.repeat(num)
    } else if (num == 4) {
        sm + md
    } else if (num == 5) {
        md
    } else if (num == 9) {
        sm + end
    } else {
        md + sm.repeat((num % 5))
    }

    fun test() {
        assertEquals("", encode(0))
        assertEquals("I", encode(1))
        assertEquals("XXI", encode(21))
        assertEquals("MMVIII", encode(2008))
        assertEquals("MDCLXVI", encode(1666))
    }
}