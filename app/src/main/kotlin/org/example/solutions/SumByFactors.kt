package org.example.solutions

import org.example.utils.assertEquals

/*
* Given an array of positive or negative integers
*
*  I= [i1,..,in]
*
* you have to produce a sorted array P of the form
*
* [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
*
* P will be sorted by increasing order of the prime numbers. The final result has to be given as a string in Java, C#, C, C++ and as an array of arrays in other languages.
*
* Example:
* I = (/12, 15/); // result = "(2 12)(3 27)(5 15)"
* [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
*
* Notes:
*
* It can happen that a sum is 0 if some numbers are negative!
* Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result, the sum of the numbers for which 5 is a factor is 0 so we have [5, 0] in the result amongst others.
*
* In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing whitespace: you can use dynamically allocated character strings.
* */
class SumByFactors {
  fun sumOfDivided(l: IntArray): String {
    val factors = mutableMapOf<Int, Int>()

    for (lIndex in l.indices) {
      var num = l[lIndex]
      var i = 1

      while (num > 1) {
        if (num % i == 0 && i != 1) num /= i
        else {
          i++
          if (num % i == 0) factors[i] = (factors[i] ?: 0) + (l[lIndex])
        }
      }
    }
    return factors.keys.sorted().fold("") { a, b -> "$a($b ${factors[b]})" }
  }
}

class TestSumByFactors {
  private val testObj = SumByFactors()
  private val sumOfDivided = testObj::sumOfDivided
  fun testOne() {
    val lst = intArrayOf(12, 15)
    assertEquals(
      "(2 12)(3 27)(5 15)", sumOfDivided(lst)
    )
  }

  fun testTwo() {
    val lst = intArrayOf(15, 21, 24, 30, 45)
    assertEquals(
      "(2 54)(3 135)(5 90)(7 21)", sumOfDivided(lst)
    )
  }

  fun testThree() {
    val lst = intArrayOf(107, 158, 204, 100, 118, 123, 126, 110, 116, 100)
    assertEquals(
      "(2 1032)(3 453)(5 310)(7 126)(11 110)(17 204)(29 116)(41 123)(59 118)(79 158)(107 107)",
      sumOfDivided(lst)
    )
  }

  fun testFour() {
    val lst = intArrayOf()
    assertEquals(
      "", sumOfDivided(lst)
    )
  }

  fun testFive() {
    val lst = intArrayOf(1070, 1580, 2040, 1000, 1180, 1230, 1260, 1100, 1160, 1000)
    assertEquals(
      "(2 12620)(3 4530)(5 12620)(7 1260)(11 1100)(17 2040)(29 1160)(41 1230)(59 1180)(79 1580)(107 1070)",
      sumOfDivided(lst)
    )
  }
}