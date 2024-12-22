package org.example.utils

/**
 * Asserts that two values are equal.
 *
 * @param expected the expected value
 * @param actual the actual value
 * @param message an optional message to display on failure
 */
fun assertEquals(expected: Any?, actual: Any?, message: String? = null) {
    if (expected != actual) {
        val errorMessage = message ?: "Expected: $expected, but was: $actual"
        throw AssertionError(errorMessage)
    }
}

fun assertArrayEquals(expected: IntArray, actual: IntArray) {
    if (expected.size != actual.size) {
        throw AssertionError("Arrays have different sizes. Expected size: ${expected.size}, Actual size: ${actual.size}")
    }

    for (i in expected.indices) {
        if (expected[i] != actual[i]) throw AssertionError("Arrays differ at index ${i}. Expected: ${expected[i]}, but was: ${actual[i]}")
    }
}

fun <T> assertArrayEquals(expected: Array<T>, actual: Array<T>) {
    if (expected.size != actual.size) {
        throw AssertionError("Arrays have different sizes. Expected size: ${expected.size}, Actual size: ${actual.size}")
    }

    for (i in expected.indices) {
        if (expected[i] != actual[i]) throw AssertionError("Arrays differ at index ${i}. Expected: ${expected[i]}, but was: ${actual[i]}")
    }
}