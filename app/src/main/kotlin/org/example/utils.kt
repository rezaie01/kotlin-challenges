package org.example.utils

/**
 * Asserts that two values are equal.
 *
 * @param expected the expected value
 * @param actual the actual value
 * @param message an optional message to display on failure
 */
public fun assertEquals(expected: Any?, actual: Any?, message: String? = null) {
    if (expected != actual) {
        val errorMessage = message ?: "Expected: $expected, but was: $actual"
        throw AssertionError(errorMessage)
    }
}