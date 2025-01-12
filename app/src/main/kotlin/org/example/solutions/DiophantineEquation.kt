package org.example.solutions

import kotlin.math.*

class DiophantineEquation {
    private fun solve4pair(x: Long, y: Long): String {
        val mn = min(x, y); val mx = max(x, y)
        val sol = ((mn + mx) / 2.toDouble() to (mx - mn) / 4.toDouble())
        return (if ((sol.first % 1 != 0.0 || sol.second % 1 != 0.0) || sol.first < 0 || sol.second < 0) "" to "" else "${sol.first.toLong()}" to "${sol.second.toLong()}").let {
            if (it.first.isEmpty()) return "" else "[${it.first}, ${it.second}]"
        }
    }

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
}

