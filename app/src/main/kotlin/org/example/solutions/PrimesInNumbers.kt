package org.example.solutions

import kotlin.math.sqrt

class PrimesInNumbers {
    fun factors(l: Int): String {
        if (l < 2) return "()"

        val primesGen = getPrimesTillNumber(l).iterator()
        var num = l
        var out = ""

        while (num > 1 && primesGen.hasNext()) {
            var p = primesGen.next()
            var count = 0
            while (num % p == 0) {
                num /= p
                count += 1
            }

            out += if (count > 1) "($p**$count)" else if (count == 1) "($p)" else ""
        }

        if (num != 1) out += "(${num})"
        return out
    }

    fun getPrimesTillNumber(num: Int): Sequence<Int> = sequence {
        if (num <= 2) {
            yield(2)
            return@sequence
        }

        val numSqrt = sqrt(num.toFloat()).toInt()

        val isPrimes = mutableMapOf<Int, Boolean>()

        var primeNum = 2
        isPrimes[2] = true
        yield(2)

        var finished = false
        while (!finished) {
            var nextPrime: Int = 0

            var i = primeNum + 1

            while (i <= numSqrt && nextPrime == 0) {
                if (isPrimes[i] != false) nextPrime = i
                else if (i % primeNum == 0) isPrimes[i] = false

                i += 1
            }

            if (i > numSqrt) finished = true

            for (j in 2 * primeNum..numSqrt step primeNum) {
                isPrimes[j] = false
            }

            //  allocate memory allows
            for (j in primeNum..<nextPrime) {
                isPrimes.remove(i)
            }

            if (nextPrime == 0) continue

            isPrimes[nextPrime] = true
            primeNum = nextPrime
            yield(primeNum)
        }

    }
}