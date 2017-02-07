package queue

import linearlist.Node

/**
 * Created by zhangll on 2017/2/7.
 */
class ChainQueue {
    var first: Node? = null
    var last: Node? = null

    init {

    }

    fun isEmpty(): Boolean {
        return first == null && last == null
    }

    fun put(element: String) {
        val node = Node(element)

        if (isEmpty()) {
            first = node
            last = node
        } else {
            last?.next = node
            last = node
        }
    }

    fun pop(): Node? {
        if (isEmpty()) {
            return null
        }

        val temp = first
        first = first?.next
        return temp
    }

    fun log() {
        var temp: Node? = first
        while (temp != null) {
            print("${temp.content} -> ")
            temp = temp.next
        }
        println("\n")
    }
}