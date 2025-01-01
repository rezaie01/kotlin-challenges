package org.example.solutions

import org.example.utils.assertEquals

class RangeExtraction {
    fun rangeExtraction(arr: IntArray): String = "".let {
        var str = it
        var rg = -1 to -1
        for (i in arr.indices) {
            if (i != arr.size - 1 && arr[i] + 1 == arr[i + 1]) {
                rg = if (rg.first != -1) (rg.first to i + 1) else (i to i + 1)
            } else if (rg.first != -1) {
                str += if (rg.second - rg.first == 1) (if (rg.first != 0) ",${arr[rg.first]}," else "${arr[rg.first]},") + "${arr[rg.second]}"
                else (if (rg.first != 0) "," else "") + "${arr[rg.first]}-${arr[rg.second]}"
                rg = -1 to -1
            } else {
                str += (if (i != 0) "," else "") + "${arr[i]}"
                rg = -1 to -1
            }
        }
        return str
    }
}

class TestRangeExtraction {
    private val rangeExtractor = RangeExtraction()
    private val rangeExtraction = rangeExtractor::rangeExtraction

    fun test() {
        assertEquals(
            "-6,-3-1,3-5,7-11,14,15,17-20",
            rangeExtraction(
                intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)
            )
        )
        assertEquals(
            "-3--1,2,10,15,16,18-20",
            rangeExtraction(intArrayOf(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20))
        )
        assertEquals(
            "-10--8,-6,-3-1,3-5,7-11,14,15,17-20",
            rangeExtraction(
                intArrayOf(
                    -10,
                    -9,
                    -8,
                    -6,
                    -3,
                    -2,
                    -1,
                    0,
                    1,
                    3,
                    4,
                    5,
                    7,
                    8,
                    9,
                    10,
                    11,
                    14,
                    15,
                    17,
                    18,
                    19,
                    20
                )
            )
        )
    }
}