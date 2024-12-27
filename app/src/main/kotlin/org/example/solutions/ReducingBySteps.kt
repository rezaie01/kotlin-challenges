package org.example.solutions

import org.example.utils.assertArrayEquals
import java.util.function.LongBinaryOperator
import kotlin.math.abs

class ReducingBySteps {
    fun gcdi(xx: Long, yy: Long): Long {
        val small: Long
        val large: Long

        if (xx > yy) {
            small = abs(yy)
            large = abs(xx)
        } else {
            small = abs(xx)
            large = abs(yy)
        }

        return if (large % small == 0L) {
            small
        } else gcdi(small, large % small)
    }

    fun lcmu(a: Long, b: Long): Long = abs(a * b) / gcdi(a, b)

    fun som(a: Long, b: Long): Long = a + b
    fun maxi(a: Long, b: Long): Long = Math.max(a, b)

    fun mini(a: Long, b: Long): Long = Math.min(a, b)

    fun operArray(ops: LongBinaryOperator, arr: LongArray, init: Long): LongArray {
        val resultArr = LongArray(arr.size)

        for (i in arr.indices) {
            resultArr[i] = ops.applyAsLong(if (i == 0) init else resultArr[i - 1], arr[i])
        }

        return resultArr
    }

    fun test() {
        println("Fixed Tests operArray : gcdi, lcmu, som, mini, maxi")
        val a = longArrayOf(18, 69, -90, -78, 65, 40)
        var r = longArrayOf(18, 3, 3, 3, 1, 1)
        assertArrayEquals(
            operArray({ x, y -> gcdi(x, y) }, a, a[0]),
            r
        )
        r = longArrayOf(18, 414, 2070, 26910, 26910, 107640)
        assertArrayEquals(
            operArray(LongBinaryOperator { a, b -> lcmu(a, b) }, a, a[0]),
            r
        )
        r = longArrayOf(18, 87, -3, -81, -16, 24)
        assertArrayEquals(
            operArray(LongBinaryOperator { a, b -> som(a, b) }, a, 0),
            r
        )
        r = longArrayOf(18, 18, -90, -90, -90, -90)
        assertArrayEquals(
            operArray(LongBinaryOperator { a, b -> mini(a, b) }, a, a[0]),
            r
        )
        r = longArrayOf(18, 69, 69, 69, 69, 69)
        assertArrayEquals(
            operArray(LongBinaryOperator({ a, b -> maxi(a, b) }), a, a[0]),
            r
        )
    }

}
