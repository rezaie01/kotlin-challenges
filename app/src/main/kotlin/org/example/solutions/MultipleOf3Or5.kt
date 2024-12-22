package org.example.solutions

import org.example.utils.assertEquals

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

Additionally, if the number is negative, return 0.

Note: If the number is a multiple of both 3 and 5, only count it once.

https://www.codewars.com/kata/514b92a657cdc65150000006/train/kotlin
*/

class MultipleOf3Or5 {
    private fun solution(number: Int): Int {
        if (number <= 0) return 0
        var sum = 0
        var by3 = 3
        var by5 = 5

        while (by3 < number || by5 < number) {
            if (by3 % 5 == 0) {
                if (by5 < number) {
                    sum += by5
                }
            } else if (by3 >= number) {
                sum += by5

            } else if (by5 >= number) {
                sum += by3

            } else {
                sum += by5
                sum += by3
            }
            by3 += 3
            by5 += 5
        }
        return sum
    }

    fun test() {
        assertEquals(23, solution(10))
        assertEquals(78, solution(20))
        assertEquals(9168, solution(200))
    }
}
