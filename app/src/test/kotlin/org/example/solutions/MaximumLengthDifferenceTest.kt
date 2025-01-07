package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumLengthDifferenceTest {
	@Test
	fun sampleTests() {
		val mxdiflg = MaximumLengthDifference()::mxdiflg
		var s1 = arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz")
		var s2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
		assertEquals(13,mxdiflg(s1, s2))
		s1 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
		s2 = arrayOf("bbbaaayddqbbrrrv")
		assertEquals(10,mxdiflg(s1, s2))
	}
}