package org.example.solutions

import org.example.utils.assertEquals
import kotlin.math.*

/*
*  Description
* Given an array X of positive integers, its elements are to be transformed by running the following operation on them as many times as required:
*
* if X[i] > X[j] then X[i] = X[i] - X[j]
*
* When no more transformations are possible, return its sum ("smallest possible sum").
*
* For instance, the successive transformation of the elements of input X = [6, 9, 21] is detailed below:
*
* X_1 = [6, 9, 12] # -> X_1[2] = X[2] - X[1] = 21 - 9
* X_2 = [6, 9, 6]  # -> X_2[2] = X_1[2] - X_1[0] = 12 - 6
* X_3 = [6, 3, 6]  # -> X_3[1] = X_2[1] - X_2[0] = 9 - 6
* X_4 = [6, 3, 3]  # -> X_4[2] = X_3[2] - X_3[1] = 6 - 3
* X_5 = [3, 3, 3]  # -> X_5[1] = X_4[0] - X_4[1] = 6 - 3
* The returning output is the sum of the final transformation (here 9).
*
* Example
* solution([6, 9, 21]) #-> 9
* Solution steps:
* [6, 9, 12] #-> X[2] = 21 - 9
* [6, 9, 6] #-> X[2] = 12 - 6
* [6, 3, 6] #-> X[1] = 9 - 6
* [6, 3, 3] #-> X[2] = 6 - 3
* [3, 3, 3] #-> X[1] = 6 - 3
* Additional notes:
* There are performance tests consisted of very big numbers and arrays of size at least 30000. Please write an efficient algorithm to prevent timeout.
* */
class SmallestPossibleSum {
    fun solveByGCD(numbers: LongArray): Long = numbers.fold(0L, ::gcd) * numbers.size

    fun solution(numbers: LongArray): Long {
        if (numbers.size == 1) return numbers[0]


        var i = 0
        var dir: Direction = Direction.RIGHT

        var rep = 0
        while (true) {
            if (i == 0) {
                dir = Direction.RIGHT
            } else if (i == numbers.size - 1) {
                dir = Direction.LEFT
            }

            val nextI = nextIndex(i, dir)
            var mn = min(numbers[i], numbers[nextI])
            var mx = max(numbers[i], numbers[nextI])

            while (mn != mx) {
                val newMx = if (mx % mn != 0L) mx % mn else mn
                val originalMn = mn
                mn = min(newMx, originalMn)
                mx = max(newMx, originalMn)
            }
            numbers[i] = mn
            numbers[nextI] = mn
            if (numbers.size == 2) break

            val prevI = prevIndex(i, numbers.size, dir)
            if (numbers[prevI] != numbers[i]) {
                dir = if (dir == Direction.LEFT) Direction.RIGHT else Direction.LEFT
//                i = i
            } else {
                i = nextI
            }
            if (dir == Direction.LEFT && i == numbers.size - 2) {
                rep++
            } else if (dir == Direction.RIGHT && i == 1 && rep > 0 ) break
        }

        return numbers.size * numbers[0]
    }
}

enum class Direction {
    LEFT, RIGHT
}

fun nextIndex(i: Int, dir: Direction): Int = if (dir == Direction.RIGHT) i + 1 else i - 1
fun prevIndex(i: Int, size: Int, dir: Direction): Int =
    if (dir == Direction.RIGHT && i > 0) i - 1
    else if (dir == Direction.RIGHT && i == 0) 1
    else if (dir == Direction.LEFT && i < size - 1) i + 1
    else if (dir == Direction.LEFT && i == size - 1) size-2
    else i

class TestSmallestPossibleSum(val withGCD: Boolean=true) {
    val solution = if (withGCD) SmallestPossibleSum()::solveByGCD else SmallestPossibleSum()::solution
    fun basicTest() {

        assertEquals(9L, solution(longArrayOf(6, 9, 21)))
        assertEquals(3L, solution(longArrayOf(1, 21, 55)))
        assertEquals(5L, solution(longArrayOf(3, 13, 23, 7, 83)))
        assertEquals(
            923L,
            solution(longArrayOf(71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71))
        )
        assertEquals(22L, solution(longArrayOf(11, 22)))
        assertEquals(2L, solution(longArrayOf(5, 17)))
        assertEquals(12L, solution(longArrayOf(4, 16, 24)))
        assertEquals(9L, solution(longArrayOf(9)))
    }

    fun testPrevIndex() {
        val size = 10
        var dir = Direction.LEFT
        var i = 0

        assertEquals(1, prevIndex(i, size, dir))
        i = size - 1
        assertEquals(i - 1, prevIndex(i, size, dir))
        dir = Direction.RIGHT
        assertEquals(i - 1, prevIndex(i, size, dir))

    }

    fun testWithDirectionChange() {
        assertEquals(7L, solution(longArrayOf(10, 20, 20, 4, 2, 22, 13)))
    }

    fun testGCD() {

        assertEquals(8L, gcd(24, 16))
        assertEquals(8L, gcd(16, 24))
        assertEquals(10L, gcd(20, 10))
    }
}

fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)