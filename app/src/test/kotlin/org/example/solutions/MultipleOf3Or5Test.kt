package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MultipleOf3Or5Test {
	
	@Test
	fun test() {
		val solution = MultipleOf3Or5()::solution
		assertEquals(23, solution(10))
		assertEquals(78, solution(20))
		assertEquals(9168, solution(200))
	}
}