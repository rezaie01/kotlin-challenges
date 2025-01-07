package org.example.solutions

class CreditCardMask {
    fun solve(cc: String): String {
        val subRange = if (cc.length < 4) 0..<(cc.length)
        else (cc.length - 4)..<cc.length

        if (cc.length <= 4) return cc

        return ("#".repeat(subRange.first)) + cc.substring((subRange))
    }


}