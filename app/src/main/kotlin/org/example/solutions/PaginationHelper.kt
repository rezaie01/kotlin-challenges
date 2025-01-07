package org.example.solutions

import org.example.utils.assertEquals
import kotlin.math.ceil

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
    fun pageIndex(itemIndex: Int): Int =if (itemIndex > itemCount - 1 || itemIndex < 0) -1 else ceil((itemIndex + 1) / (itemsPerPage).toDouble()).toInt() - 1
}