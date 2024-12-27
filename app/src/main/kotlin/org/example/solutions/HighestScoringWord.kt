package org.example.solutions

/*
*  challenge Link
*  https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/kotlin
* */
class HighestScoringWord {
    fun high(str: String): String {
        var highScorer: Pair<String, Int> = "" to 0

        val alph = "abcdefghijklmnopqrstuvwxyz"

        str.split(" ").forEach { word ->
            var score = 0
            word.forEach { ch -> score+=alph.indexOf(ch) + 1 }
            if (score > highScorer.second) highScorer = word to score
        }

        return highScorer.first
    }
}