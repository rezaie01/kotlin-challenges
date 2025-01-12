package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class CanYouGetTheLoopTest {

    val loopSize = CanYouGetTheLoop()::loopSize

    @Test
    fun loop_size_of_1() {
        val list = Node.createChain(0, 1)
        val result = list?.let { loopSize(it) }
        assertEquals(1L, (result?:-1).toLong(), "Incorrect loop size")
    }

    @Test
    fun loop_and_no_tail() {
        val list = Node.createChain(0, 10)
        val result = list?.let { loopSize(it) }
        assertEquals(10, (result?:-1).toLong(), "Incorrect loop size")
    }

    @Test
    fun long_tail_short_loop() {
        val list = Node.createChain(8778, 23)
        val result = list?.let{loopSize(list)}
        assertEquals(23, (result?:-1).toLong(), "Incorrect loop size")
    }

    @Test
    fun short_tail_long_loop() {
        val list = Node.createChain(23, 8778)
        val result = list?.let{loopSize(list)}
        assertEquals(8778, (result?:-1).toLong(), "Incorrect loop size")
    }

    @Test
    fun random_tail_and_loop_size() {
        for (i in 0..10) {
            val loopSize = Random.nextInt(0, 1_000_000)
            val tailSize = Random.nextInt(0, 1_000_000)

            val list = Node.createChain(tailSize, loopSize)
            val result = list?.let{loopSize(list)}
            assertEquals(loopSize, result, "Incorrect loop size")
        }
    }

}