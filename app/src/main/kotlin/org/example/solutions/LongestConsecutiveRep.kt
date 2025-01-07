package org.example.solutions

/*
*
* For a given string s find the character c (or C) with longest consecutive repetition and return:

* Pair(c, l)
* where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.
*
* For empty string return:
*
* Pair(null, 0)
*
* */
class LongestConsecutiveRep {
    fun longestRepetition(s: String): Pair<Char?, Int> {

        // store the current consecutive repetition
        var currentRep = 0

        // store the highest repetition and the char
        var maxPair: Pair<Char?, Int> = null to 0

        // loop over the string
        for (i in s.indices) {
            // if this ch same as before count up
            if (i == 0) {
                currentRep = 1
                println("$currentRep rep")
            } else if (s[i] == s[i - 1]) {
                currentRep += 1
                println("rep up ${s[i]} $i $currentRep")
            } else {
                if (currentRep > maxPair.second) {
                    maxPair = (s[i - 1] to currentRep)
                }
                currentRep = 1
            }
        }

        if (currentRep > maxPair.second)
            maxPair = (s[s.length - 1] to currentRep)


// return the highest repetition
        return maxPair
    }
}