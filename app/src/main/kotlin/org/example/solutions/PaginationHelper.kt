package org.example.solutions

import org.example.utils.assertEquals
import kotlin.math.ceil
import kotlin.math.floor

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.size
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            return ceil(collection.size / itemsPerPage.toDouble()).toInt()
        }


    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int =
        if (pageIndex < 0 || pageIndex > pageCount - 1) -1 else if (pageIndex < pageCount - 1) itemsPerPage else itemCount - (pageCount - 1) * itemsPerPage


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int =
        if (itemIndex > itemCount - 1 || itemIndex < 0) -1 else ceil(((itemIndex + 1) / itemsPerPage).toDouble()).toInt() - 1


}

class PaginationHelperTest {
    fun testItemCount() {
        val helper = PaginationHelper<Int>(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3)
        assertEquals(11, helper.itemCount, "itemCount is returning incorrect value")
    }

    fun testPageCount() {
        val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(2, helper.pageCount, "pageCount is returning incorrect value")
    }

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

    fun testPageIndexOfAnItem() {
        var helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(-1, helper.pageIndex(-1), "pageCount is returning incorrect value")
        assertEquals(1, helper.pageIndex(3), "pageCount is returning incorrect value")

        helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 4)
        assertEquals(-1, helper.pageIndex(8), "pageCount is returning incorrect value")
        assertEquals(1, helper.pageIndex(7), "pageCount is returning incorrect value")

    }
}