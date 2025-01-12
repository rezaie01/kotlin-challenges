package org.example.solutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun testCreateChainCreatesTails() {
        assertEquals(1, getNumberOfNodes(Node.createChain(1)))
        assertEquals(0, getNumberOfNodes(Node.createChain()))
        assertEquals(10, getNumberOfNodes(Node.createChain(10)))
        assertEquals(8778 , getNumberOfNodes(Node.createChain(8778)))

    }

    @Test
    fun testCreateChainCreatesTailsAndLoops() {
        assertEquals(1, getNumberOfNodes(Node.createChain(loopSize = 1)))
        assertEquals(10, getNumberOfNodes(Node.createChain(10, 0)))
        assertEquals(11, getNumberOfNodes(Node.createChain(10, 1)))
        assertEquals(10, getNumberOfNodes(Node.createChain(loopSize = 10)))
        assertEquals(10, getNumberOfNodes(Node.createChain(2, 8)))
        assertEquals(4, getNumberOfNodes(Node.createChain(2, 2)))
        assertEquals(4, getNumberOfNodes(Node.createChain(1, 3)))
        assertEquals(3, getNumberOfNodes(Node.createChain(1, 2)))
        assertEquals(2, getNumberOfNodes(Node.createChain(1, 1)))
        assertEquals(1, getNumberOfNodes(Node.createChain(0, 1)))
        assertEquals(0, getNumberOfNodes(Node.createChain()))
        assertEquals(8778 + 23, getNumberOfNodes(Node.createChain(8778, 23)))
        assertEquals(23, getNumberOfNodes(Node.createChain(0, 23)))

    }

    private fun getNumberOfNodes(list: Node?): Int {
        val nodeTracker = mutableMapOf<Node, Int>()

        var nodeCount = 0
        var currentNode: Node? = list
        while (currentNode != null) {
            nodeCount++

            nodeTracker[currentNode] = nodeCount
            if (nodeTracker[currentNode.next] != null) break
            currentNode = currentNode.next
        }

        return nodeCount
    }
}