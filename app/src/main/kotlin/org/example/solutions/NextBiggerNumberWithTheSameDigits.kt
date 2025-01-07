package org.example.solutions

/*
* Create a function that takes a positive integer and returns the next bigger number that can be formed by rearranging its digits. For example:
*
*   12 ==> 21
*  513 ==> 531
* 2017 ==> 2071
* If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift, None in Rust):
*
*   9 ==> -1
* 111 ==> -1
* 531 ==> -1
*
* https://www.codewars.com/kata/55983863da40caa2c900004e/train/kotlin
* */
class NextBiggerNumberWithTheSameDigits {
  fun nextBiggerNumber(n: Long): Long {
    val lDigits = n.toString().map { c -> c.digitToInt() }.toMutableList()

    println(lDigits)
    for (i in lDigits.size - 2 downTo 0) {
      if (lDigits[i] < lDigits[i + 1]) {
        if (i == lDigits.size - 2) {
          val m = lDigits[i]
          lDigits[i] = lDigits[i + 1]
          lDigits[i + 1] = m
          return lDigits.joinToString("").toLong()
        }
        val digitsSlice = lDigits.slice(i..<lDigits.size).sorted().toMutableList()
        val originalNum = lDigits.slice(i..<lDigits.size).joinToString("").toLong()

        for (sliceI in 1..<digitsSlice.size) {
          val m = digitsSlice[0]
          digitsSlice[0] = digitsSlice[sliceI]
          digitsSlice[sliceI] = m
          if (digitsSlice.joinToString("").toLong() > originalNum) {
            return (lDigits.slice(0..<i).joinToString("") + digitsSlice.joinToString("")).toLong()
          }
        }
        break
      }
    }
    return -1L
  }
}