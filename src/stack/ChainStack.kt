package stack

import linearlist.Node

/**
 * Created by zhangll on 2017/2/10.
 */
class ChainStack {
    var top: Node? = null

    fun isEmpty(): Boolean {
        return top == null
    }

    fun put(element: String) {
        val node = Node(element)

        if (isEmpty()) {
            top = node
        } else {
            node.next = top
            top = node
        }
    }

    fun pop(): Node? {
        if (top == null) {
            return null
        } else {
            val pop = top
            top = top!!.next
            return pop
        }
    }

    fun log() {
        var temp: Node? = top
        while (temp != null) {
            print("${temp.content} -> ")
            temp = temp.next
        }
        println("\n")
    }
}