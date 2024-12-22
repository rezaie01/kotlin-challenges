package org.example.solutions

import org.example.utils.assertEquals

val EXERCISE_NAME = "Maximum Length Difference"
// import org.junit.jupiter.api.Test
// import kotlin.test.assertEquals
/*
    You are given two arrays a1 and a2 of strings. Each string is composed with letters
    from a to z. Let x be any string in the first array and y be any string in the second
     array.

    Find `max(abs(length(x) − length(y)))`

    If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will
    return Nothing (None).
*/
class MaximumLengthDifference {

    private fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        if (a1.size == 0 || a2.size == 0) return -1

        var Max = 0

        for (aString in a1) {
            for (bString in a2) {
                val diff = Math.abs(bString.length - aString.length)
                if (diff > Max) Max = diff
            }
        }

        return Max
    }

    // @Test
    fun test() {

        var s1 = arrayOf<String>(
                        "hoqq")
                        // "bbllkw",
                        // "oox",
                        // "ejjuyyy",
                        // "plmiis",
                        // "xxxzgpsssa",
                        // "xxwwkktt",
                        // "znnnnfqknaz",
                        // "qqquuhii",
                        // "dvvvwz"
//                        )
        var s2: Array<String> = arrayOf()
        // var s2 = arrayOf<String>("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
        assertEquals(13, mxdiflg(s1, s2))
        s1 =
                arrayOf<String>(
                        "ejjjjmmtthh",
                        "zxxuueeg",
                        "aanlljrrrxx",
                        "dqqqaaabbb",
                        "oocccffuucccjjjkkkjyyyeehh"
                )
        s2 = arrayOf<String>("bbbaaayddqbbrrrv")
        assertEquals(10, mxdiflg(s1, s2))

        println("\nSUCCESSFUL solved [$EXERCISE_NAME]")
    }
}
