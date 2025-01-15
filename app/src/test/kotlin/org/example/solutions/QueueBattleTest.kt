package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueueBattleTest {
    private fun runTest(sol:Pair<Int,IntArray>,n:Int,vararg r:IntArray) {
        val (winner,survivors) = sol
        val (userWinner,userSurv) = queueBattle(n,*r)
        assertEquals(winner,userWinner)
        assertEquals(survivors.joinToString(","),userSurv.joinToString(","))
    }

    @Test
    fun runExamples() {
        runTest(
            Pair(1,intArrayOf(3,2)),// expected
            100,// dist
            intArrayOf(25,38,55,46,82),// army 0
            intArrayOf(64,90,37,25,58))// army 1
        runTest(
            Pair(0,intArrayOf(6,7)),
            200,
            intArrayOf(61,83,37,55,92,35,68,72),
            intArrayOf(90,81,36,114,67,25,31,84))
        runTest(
            Pair(0,intArrayOf(2)),
            300,
            intArrayOf(98,112,121,95,63),
            intArrayOf(120,94,90,88,30),
            intArrayOf(116,144,45,200,32))
        runTest(
            Pair(2,intArrayOf(0,2,5)),
            400,
            intArrayOf(186,78,56,67,78,127,78,192),
            intArrayOf(78,67,208,45,134,212,82,99),
            intArrayOf(327,160,49,246,109,98,44,57))
        runTest(
            Pair(-1,intArrayOf()),
            500,
            intArrayOf(345,168,122,269,151),
            intArrayOf(56,189,404,129,101),
            intArrayOf(364,129,209,163,379),
            intArrayOf(520,224,154,74,420))
    }
}