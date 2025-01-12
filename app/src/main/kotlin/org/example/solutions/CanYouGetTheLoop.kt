package org.example.solutions

class CanYouGetTheLoop {
    fun loopSize(n: Node): Int {
        val nodeTracker = mutableMapOf<Node, Int>()

        var nodeCount = 0
        var currentNode: Node? = n
        while (currentNode != null) {
            nodeCount++

            nodeTracker[currentNode] = nodeCount
            if (nodeTracker[currentNode.next] != null) break
            currentNode = currentNode.next
        }

        return if (currentNode == null) nodeCount else nodeCount - (nodeTracker[currentNode.next]?:(nodeCount - 1)) + 1
    }

}


class Node(var next: Node? = null) {
    companion object {

        fun createChain(tail: Int = 0, loopSize: Int = 0): Node? {
            var (node0, tailEnd) = createTail(tail)

            if (loopSize > 0) {
                val (loopStartNode, loopEnd) = createTail(loopSize)
                loopEnd!!.next = loopStartNode

                if (node0 != null) {
                    tailEnd!!.next = loopStartNode
                } else {
                    node0 = loopStartNode
                }
            }

            return node0
        }

        private fun createTail(tail: Int): Pair<Node?, Node?> {
            if (tail <= 0) return null to null
            val node0 = Node()
            var currentNode: Node? = node0

            for (i in 1..<tail) {
                currentNode!!.next = Node()
                currentNode = currentNode.next
            }
            return node0 to currentNode
        }


    }
}