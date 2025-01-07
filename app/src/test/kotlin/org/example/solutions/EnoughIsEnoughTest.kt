package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EnoughIsEnoughTest {
	private val testObj = EnoughIsEnough()
	@Test
	@Throws(Exception::class)
	fun deleteNth() {
		assertArrayEquals(
			intArrayOf(20, 37, 21),
			testObj.deleteNth(intArrayOf(20, 37, 20, 21), 1)
		)
		assertArrayEquals(
			intArrayOf(1, 1, 3, 3, 7, 2, 2, 2),
			testObj.deleteNth(intArrayOf(1, 1, 3, 3, 7, 2, 2, 2, 2), 3)
		)
		assertArrayEquals(
			intArrayOf(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5),
			testObj.deleteNth(intArrayOf(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3)
		)
		assertArrayEquals(
			intArrayOf(1, 1, 1, 1, 1),
			testObj.deleteNth(intArrayOf(1, 1, 1, 1, 1), 5)
		)
		assertArrayEquals(
			intArrayOf(),
			testObj.deleteNth(intArrayOf(), 5)
		)
	}
}