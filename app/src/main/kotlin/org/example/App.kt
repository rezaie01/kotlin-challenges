package org.example

import org.example.solutions.EncodeRoman
import org.example.solutions.PaginationHelperTest
import org.example.solutions.PrimesInNumbers
import org.example.solutions.ReducingBySteps
import org.example.solutions.ReverseOrRotate
import org.example.solutions.SmallCodeInterpreter
import org.example.solutions.TortoiseRacing
import org.example.solutions.ZonkTests
import org.example.solutions.bracketMatcher

//import org.example.solutions.CreditCardMask
//import org.example.solutions.MultipleOf3Or5

fun main() {
    // TestEnoughIsEnough()

    // MaximumLengthDifference().test()

    //    MultipleOf3Or5().test()
    //    CreditCardMask().test()
    //    TortoiseRacing().test()

//    var interpreter = SmallCodeInterpreter(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.")
//    println(interpreter.process("${8.toChar()}${9.toChar()}"))
//
//    interpreter = SmallCodeInterpreter(",+[-.,+]")
//    println(interpreter.process("Codewars${255.toChar()}"))
////    bracketMatcher(strWithBracket).forEach { println("(${strWithBracket[it.key]} ${it.key}, ${strWithBracket[it.value]} ${it.value})")}
//
//    interpreter = SmallCodeInterpreter(",[>[-]<[-]]")
//    println(interpreter.process(10.toChar().toString()))

//    val interpreter = SmallCodeInterpreter(",>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++<<<<<<")
//    println(interpreter.process(10.toChar().toString()))

//    val interpreter = SmallCodeInterpreter(",>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>>>[++++++++++++++++++++++++++++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++++++++++++++++++++++++++++++++++++++++++++++.[-]<<<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>-]<<<-]")
//    println(interpreter.process(10.toChar().toString()))

//    val red = ReducingBySteps()
//
//    println(red.gcdi(9223372036854775807, 932480942438401189))
//    println(red.gcdi(922337236854775907, 932480342438901189))
//    println(red.gcdi(-922337536854785807, 932480342458401189))
//    println(red.gcdi(9223132036854975807, 932480343438401189))
//    println(red.gcdi(9223372016854770807, 932488342438401189))
//    println(red.lcmu(30843, 932480384089))
//    red.test()

//val roman = EncodeRoman()
//    roman.test()
//    println(roman.encode(340))

//    val p = PrimesInNumbers()
//    println(p.factors(90))
//    println(p.factors(7775460))
//    println(p.factors(9))
//    println(p.factors(2))
//    println(p.factors(7))
//    println(p.factors(175))
//    println(p.factors(155))
//    println(p.factors(Int.MAX_VALUE - 2))
//
//

//    val tester = PaginationHelperTest()
//    tester.testItemCount()
//    tester.testPageCount()
//    tester.testPageItemsCountAtNthPage()

    val zonkGameTester = ZonkTests()
    zonkGameTester.test1()
    zonkGameTester.test2()
}
