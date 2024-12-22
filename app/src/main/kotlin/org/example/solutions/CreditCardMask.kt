package org.example.solutions

import org.example.utils.assertEquals

class CreditCardMask {
    private fun solution(cc: String): String {
        val subRange = if (cc.length < 4) 0..<(cc.length)
        else (cc.length - 4)..<cc.length

        if (cc.length <= 4) return cc

        return ("#".repeat(subRange.first)) + cc.substring((subRange))
    }

    fun test() {
        assertEquals("", solution(""))
        assertEquals("123", solution("123"))
        assertEquals("########d2eA", solution("SF&SDfgsd2eA"))
    }
}