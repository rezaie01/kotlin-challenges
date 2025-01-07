package org.example.solutions

val EXERCISE_NAME = "Maximum Length Difference"
// import org.junit.jupiter.api.Test
// import kotlin.test.assertEquals
/*
    You are given two arrays a1 and a2 of strings. Each string is composed with letters
    from a to z. Let x be any string in the first array and y be any string in the second
     array.

    Find `max(abs(length(x) − length(y)))`

    If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will
    return Nothing (None).
*/
class MaximumLengthDifference {
  
  fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
    if (a1.isEmpty() || a2.isEmpty()) return -1
    
    var max = 0
    
    for (aString in a1) {
      for (bString in a2) {
        val diff = Math.abs(bString.length - aString.length)
        if (diff > max) max = diff
      }
    }
    
    return max
  }
  
}
