package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PaginationHelperTest {

	@Test
	fun testItemCount() {
		val helper = PaginationHelper<Int>(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3)
		assertEquals(11, helper.itemCount, "itemCount is returning incorrect value")
	}
	
	@Test
	fun testPageCount() {
		val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
		assertEquals(2, helper.pageCount, "pageCount is returning incorrect value")
	}
	
	@Test
	fun testPageItemsCountAtNthPage() {
		var helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 2)
		assertEquals(2, helper.pageItemCount(0))
		
		assertEquals(1, helper.pageItemCount(3))
		assertEquals(-1, helper.pageItemCount(4))
		assertEquals(-1, helper.pageItemCount(-1))
		assertEquals(2, helper.pageItemCount(2))
		
		helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 2)
		assertEquals(2, helper.pageItemCount(2))
	}
	
	@Test
	fun testPageIndexOfAnItem() {
		var helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
		assertEquals(
			-1,
			helper.pageIndex(-1),
			"pageCount is returning incorrect value"
		)
		assertEquals(0, helper.pageIndex(3), "pageCount is returning incorrect value")
		
		helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 4)
		assertEquals(
			-1,
			helper.pageIndex(8),
			"pageCount is returning incorrect value"
		)
		assertEquals(1, helper.pageIndex(6), "pageCount is returning incorrect value")
		
	}
}