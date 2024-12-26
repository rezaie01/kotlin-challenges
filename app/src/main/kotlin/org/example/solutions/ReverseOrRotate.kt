package org.example.solutions

import org.example.utils.assertEquals

/*
*   REVERSE OR ROTATE
*
* The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).


* If the sum of a chunk's digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.
*
* If
*
* sz is <= 0 or if str == "" return ""
* sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
*
* * Examples:
* ```
* ("123456987654", 6) --> "234561876549"
* ("123456987653", 6) --> "234561356789"
* ("66443875", 4) --> "44668753"
* ("66443875", 8) --> "64438756"
* ("664438769", 8) --> "67834466"
* ("123456779", 8) --> "23456771"
* ("", 8) --> ""
* ("123456779", 0) --> ""
* ("563000655734469485", 4) --> "0365065073456944"
* ```
* Example of a string rotated to the left by one position:
* ```
* s = "123456" gives "234561".
* ```
* */
class ReverseOrRotate {
    fun revRot(nums:String, sz:Int): String {
        if (nums.isEmpty() || sz <=0) return ""
        if (sz > nums.length) return ""

        var finalStr = "";

        println("SIZE $sz\n")
        // go through the chunks
        for (i in 0..<(nums.length / sz)) {
            val start = i * sz
            val end = start + sz
            var log = "i [$i] start[$start] end[$end] "
            var subStr = nums.substring(start..<end)

            // calc the sum and decide to rotate or reverse
            var digitSum = 0
            subStr.forEach { digitSum += it.digitToInt() }

            log += "$subStr $digitSum"
            // reverse or rotate and concatenate with resulting string
            subStr = if (digitSum % 2 == 0) subStr.reversed() else subStr.substring(1..<subStr.length) + subStr[0]

            log += " $subStr"
            println(log)
            finalStr += subStr
        }
        return finalStr
    }

    fun test() {
        var s = "733049910872815764"
        var result = "330479108928157"
        assertEquals(result, revRot(s, 5))
        s = "73304991087281576455176044327690580265896";result="1994033775182780067155464327690480265895"
        assertEquals(result, revRot(s, 8))
        s = "73304991087281576455176044327690580265896896028";result="1994033775182780067155464327690480265895"
        assertEquals(result, revRot(s, 8))

    }
}