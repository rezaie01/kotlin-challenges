package org.example.solutions

import org.example.utils.assertEquals
import kotlin.math.*

class DiophantineEquation {
    fun solEquaStr(n: Long): String {
        var solutions = ""
        solutions += solve4pair(1, n)
        var i = 2L
        do {
            if (n % i == 0L) {
                solve4pair(
                    n / i,
                    i
                ).let { s -> if (s.isNotEmpty()) solutions += if (solutions.isNotEmpty()) ", $s" else s }
            }
            i++
        } while (i <= sqrt(n.toDouble()).toLong())
        return "[$solutions]"
    }

    private fun solve4pair(x: Long, y: Long): String {
        val mn = min(x, y); val mx = max(x, y)
        val sol = ((mn + mx) / 2.toDouble() to (mx - mn) / 4.toDouble())
        return (if ((sol.first % 1 != 0.0 || sol.second % 1 != 0.0) || sol.first < 0 || sol.second < 0) "" to "" else "${sol.first.toLong()}" to "${sol.second.toLong()}").let {
            if (it.first.isEmpty()) return "" else "[${it.first}, ${it.second}]"
        }
    }
}

class TestDiophantineEquation {
    private val equation = DiophantineEquation()
    private val solEquaStr = equation::solEquaStr
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