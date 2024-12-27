package org.example.solutions

/*
* Challenge Link
* https://www.codewars.com/kata/5ce399e0047a45001c853c2b/train/kotlin
* */
class SumsOfParts {
    fun sumParts(ls: IntArray): IntArray {
        var sum = ls.sum()

        val sumsArr = IntArray(ls.size + 1)

        sumsArr[0] = sum
        for (i in ls.indices) {
            sum -= ls[i]
            sumsArr[i + 1] = sum
        }

        return sumsArr
    }
}