package org.example.solutions

import org.example.utils.assertEquals

class ZonkGame {
    fun getScore(dice: IntArray): Int {
        val reps = intArrayOf(0, 0, 0, 0, 0, 0, 0)

        for (i in dice.indices) {
            reps[dice[i]] += 1
        }

        var points = 0

        val pointsOf3s = intArrayOf(0, 1000, 200, 300, 400, 500, 600)

        var straightCounter = 0
        var pairCount = 0

        for (i in 1..6) {
            val rep = reps[i]
            when (rep) {
                6 -> {
                    points = 4 * pointsOf3s[i]
                }

                5 -> {
                    points += 3 * pointsOf3s[i]
                }

                4 -> {
                    points += 2 * pointsOf3s[i]
                }

                3 -> {
                    points += pointsOf3s[i]
                }

                2 -> {
                    when (i) {
                        1 -> points += 200
                        5 -> points += 100
                    }
                    pairCount += 1
                }

                1 -> {
                    when (i) {
                        1 -> points += 100
                        5 -> points += 50
                    }
                    straightCounter += 1
                }
            }

        }

//      recheck for doubles
        if (pairCount == 3) points = 750
        if (straightCounter == 6) return 1000

        return points
    }
}

class ZonkTests {
    val zonkGame = ZonkGame()
    fun test1() {
        println("Single die")
        doTest(intArrayOf(1), 100)
        doTest(intArrayOf(2), 0)
        doTest(intArrayOf(3), 0)
        doTest(intArrayOf(4), 0)
        doTest(intArrayOf(5), 50)
        doTest(intArrayOf(6), 0)
    }

    fun test2() {
        println("Multiple dice")
        doTest(intArrayOf(1, 1), 200)
        doTest(intArrayOf(1, 1, 1), 1000)
        doTest(intArrayOf(1, 2, 3, 4, 5, 6), 1000)
        doTest(intArrayOf(2, 2, 3, 3, 6, 6), 750)
        doTest(intArrayOf(1, 1, 3, 3, 6, 6), 750)
        doTest(intArrayOf(1, 1, 1, 3, 6, 6), 1000)
        doTest(intArrayOf(3, 1, 1, 6, 6, 6), 800)
        doTest(intArrayOf(3, 1, 1, 5, 6, 6), 250)
        doTest(intArrayOf(3, 2, 6, 4, 4, 6), 0)
    }

    private fun doTest(dice: IntArray, expected: Int) {
        assertEquals(expected, zonkGame.getScore(dice), "(" + dice.joinToString() + ")")
    }
}