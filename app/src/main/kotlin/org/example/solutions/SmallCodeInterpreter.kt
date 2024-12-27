package org.example.solutions

/*
* My Smallest Code Interpreter (aka Brainf*k)
* Inspired from real-world Brainf**k, we want to create an interpreter of that language which will support the following instructions:
*
* > increment the data pointer (to point to the next cell to the right).
* < decrement the data pointer (to point to the next cell to the left).
* + increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
* - decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
* . output the byte at the data pointer.
* , accept one byte of input, storing its value in the byte at the data pointer.
* [ if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ] command.
* ] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [ command.
* The function will take in input...
*
* the program code, a string with the sequence of machine instructions,
* the program input, a string, possibly empty, that will be interpreted as an array of bytes using each character's ASCII code and will be consumed by the , instruction
* ... and will return ...
*
* the output of the interpreted code (always as a string), produced by the . instruction.
* Implementation-specific details for this Kata:
*
* Your memory tape should be large enough - the original implementation had 30,000 cells but a few thousand should suffice for this Kata
* Each cell should hold an unsigned byte with wrapping behavior (i.e. 255 + 1 = 0, 0 - 1 = 255), initialized to 0
* The memory pointer should initially point to a cell in the tape with a sufficient number (e.g. a few thousand or more) of cells to its right. For convenience, you may want to have it point to the leftmost cell initially
* You may assume that the , command will never be invoked when the input stream is exhausted
* Error-handling, e.g. unmatched square brackets and/or memory pointer going past the leftmost cell is not required in this Kata. If you see test cases that require you to perform error-handling then please open an Issue in the Discourse for this Kata (don't forget to state which programming language you are attempting this Kata in).
*
* https://www.codewars.com/kata/526156943dfe7ce06200063e/train/kotlin
* */
class SmallCodeInterpreter(private val code: String) {
    private val memory = Memory(3000)

    fun process(input: String): String {
        var output: String = ""

        var loops: Map<Int, Int> = mapOf()
        var loopsReverseMap: Map<Int, Int> = mapOf()

//        track where do the current & prev loop start
        var inputIndex = 0
        var codeIndex = 0

        do {
            val command = code[codeIndex]

            when (command) {
                '>' -> memory.nextCell()
                '<' -> memory.prevCell()
                '+' -> memory.increment()
                '-' -> memory.decrement()
                '.' -> {
                    output += memory.show()
                }

                ',' -> {
                    if (inputIndex >= input.length) throw IndexOutOfBoundsException("More input request, but not provided")
                    else {
                        memory.fill(input[inputIndex])
                        inputIndex += 1
                    }
                }
//               start of the loop
                '[' -> {
                    // find all brackets when you encounter the first bracket
                    if (loops[codeIndex] == null) {
                        loops = bracketMatcher(code, codeIndex)
                        loopsReverseMap = loops.entries.associate { it.value to it.key }
                    }

                    // if jump or not
                    if (memory.show() == 0.toChar()) {
                        loops[codeIndex].let {
                            when (it) {
                                null -> throw Error("IMPOSSIBLE")
                                else -> codeIndex = it + 1
                            }
                        }
                        continue
                    }
                }

//               end of a loop
                ']' -> {
                    // if jump or not
                    if (memory.show() != 0.toChar()) {
                        // find the pair bracket
                        codeIndex = loopsReverseMap[codeIndex]?.plus(1) ?: 0
                        continue
                    } else {
//                        set the prev loop as current and prev to -1
//                        currentLoopIndex = prevLoopIndex
//                        prevLoopIndex = -1
                    }

                }
            }

            codeIndex += 1
        } while (codeIndex < code.length)

        return output
    }

}

private class Memory(val size: Int) {
    private val mem = arrayOfNulls<Cell>(size)
    private var index = 0

    private var current
        get() = mem[index]
        set(value) {
            mem[index] = value
        }

    fun nextCell(): Boolean {
        if (index + 1 >= size) return false
        else {
            index += 1
            return true

        }

    }

    fun prevCell(): Boolean {
        if (index < 1) return false
        else {
            index -= 1
            return true

        }

    }

    fun fill(ch: Char) {
        if (current == null) mem[index] = Cell(ch) else current?.fill(ch)
    }

    fun show() = mem[index]?.show()

    fun increment() {
        if (current == null) current = Cell()
        current?.up()
    }

    fun decrement() {
        if (current == null) current = Cell()
        current?.down()
    }

}

class Cell(private val initialChar: Char = 0.toChar()) {
    private var value: UByte = initialChar.code.toUByte()
    fun fill(ch: Char) {
        value = ch.code.toUByte()
    }

    fun show(): Char = Char(value.toInt())
    fun up() {
        value = (value + 1u).toUByte()
    }

    fun down() {
        value = (value - 1u).toUByte()
    }
}

public fun bracketMatcher(str: String, start: Int = 0): Map<Int, Int> {
    val pairsFound: MutableMap<Int, Int> = mutableMapOf()
    var pair = -1 to -1
    var i = start

    while (i < str.length) {
        if (str[i] == '[') {
            if (pair.first == -1) {
                pair = i to pair.second
            } else {
                val foundInside = bracketMatcher(str, i)
                var lastSearched = i
                for ((a, b) in foundInside) {
                    pairsFound[a] = b
                    if (b > lastSearched) lastSearched = b
                }

                i = lastSearched + 1
                continue
            }
        }

        if (str[i] == ']') {
            pair = pair.first to i
            break
        }

        i += 1
    }

    pairsFound[pair.first] = pair.second
    return pairsFound
}
