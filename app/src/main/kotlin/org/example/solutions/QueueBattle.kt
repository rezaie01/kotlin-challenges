package org.example.solutions

import java.util.LinkedList
import java.util.Queue
import kotlin.math.ceil
/*
*
* Solve "Queue Battle" kata in CodeWars
* https://www.codewars.com/kata/5d617c2fa5e6a2001a369da2
* */
fun queueBattle(dist: Int, vararg armies: IntArray): Pair<Int, IntArray> {
    val battleArmies = armies.mapIndexed { i, soldiers -> Army(soldiers, dist, i) }.toMutableList()
    val bullets = mutableMapOf<Int, MutableList<Int>>()

    var round = 1
    var hasFallenArmies = false
    outer@ do {
        if (hasFallenArmies) {
            bullets.clear()
            round = 1
            hasFallenArmies = false
            continue@outer
        }

        var armyI = 0
        while (armyI < battleArmies.size) {
            val currentArmy = battleArmies[armyI]
            val targetArmy = battleArmies[if (armyI != battleArmies.size - 1) armyI + 1 else 0]

            val anyBulletIncoming = bullets[round]?.find { armyNum -> armyNum == currentArmy.pos }
            val hitRound = currentArmy.fire(round, anyBulletIncoming != null)

//            fire, cause the head is not dead.
            if (hitRound != null) {
                if (bullets[hitRound] != null) {
                    bullets[hitRound]!!.add(targetArmy.pos)
                } else {
                    bullets[hitRound] = mutableListOf(targetArmy.pos)
                }
            }

            if ( currentArmy.isFallen() ) {
                battleArmies.removeAt(armyI)
                hasFallenArmies = true
                continue
            }

            armyI++
        }

        bullets.remove(round)
        round++
    } while (battleArmies.size > 1)

    if (battleArmies.size == 0) return -1 to intArrayOf()
    return battleArmies[0].pos to battleArmies[0].soldiers.map { sld -> sld.originalPos }.toIntArray()
}

data class Soldier(val originalPos: Int, val bulletSpeed: Int)

class Army(initSoldiers: IntArray, private val dist: Int, val pos: Int) {
    private val queue: Queue<Soldier> = LinkedList(initSoldiers.mapIndexed { i, bulletSpeed -> Soldier(i, bulletSpeed)})

    val soldiers: Array<Soldier>
        get() = queue.toTypedArray()

    fun fire(round: Int, isDead: Boolean = false): Int? {
        if (isFallen()) println("________\nFALLEN\n-----------")
        if (isDead) {
            queue.remove()
            return null
        }

        val hitRound =  round + ceil(dist / queue.peek().bulletSpeed.toDouble()).toInt()
        val headSoldier = queue.remove()
        queue.add(headSoldier)
        return hitRound
    }

    fun isFallen(): Boolean = queue.isEmpty()
}