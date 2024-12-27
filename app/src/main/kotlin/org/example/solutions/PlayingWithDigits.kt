package org.example.solutions

import kotlin.math.pow

/*
* Challenge Link
* https://www.codewars.com/kata/5552101f47fc5178b1000050/train/kotlin
* */
class PlayingWithDigits {
    fun digPow(n: Int, p: Int): Int {
        val nStr = n.toString()
        var sum = 0
        for (i in nStr.indices) {
            sum += nStr[i].digitToInt().toFloat().pow(p + i).toInt()
        }

        return if (sum % n == 0) sum / n else -1
    }
}