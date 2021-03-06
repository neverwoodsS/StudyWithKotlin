package linearlist

/**
 * Created by zhangll on 2017/1/16.
 */
class Chain {
    val head by lazy { Node("head") }

    init {
        var temp = head
        for (i in 0..4) {
            temp.next = Node(i.toString())
            temp = temp.next!!
        }
    }

    fun addElementToFirst(element: Node) {
        element.next = head.next
        head.next = element
    }

    fun addElementToLast(element: Node) {
        var temp: Node? = head
        while (temp != null && temp.next != null) {
            temp = temp.next
        }
        temp?.next = element
    }

    fun addElementToIndex(element: Node, index: Int) {
        var temp: Node? = head
        var position = 0

        while (temp != null) {
            if (position == index) {
                element.next = temp.next
                temp.next = element
                break
            }

            temp = temp.next
            position++
        }
    }

    fun deleteFirst() {
        head.next = head.next?.next
    }

    fun deleteLast() {
        var temp: Node? = head
        while (temp != null && temp.next != null && temp.next?.next != null) {
            temp = temp.next
        }
        temp?.next = null
    }

    fun deleteAtIndex(index: Int) {
        var temp: Node? = head
        var position = 0

        while (temp != null) {
            if (position == index) {
                temp.next = temp.next?.next
                break
            }

            temp = temp.next
            position++
        }
    }

    fun deleteNode(node: Node) {
        if (node.next == null) {
            println("delete after loop")
            var temp: Node = head
            while (temp.next != node) {
                if (temp.next == head) {
                    println("i don't have this element")
                    return
                }
                temp = temp.next!!
            }

            temp.next = node.next

        } else {
            println("delete directly")
            node.content = node.next!!.content
            node.next = node.next!!.next
        }
    }

    fun reserve() {
        var temp: Node? = head.next
        head.next = null

        while (temp != null) {
            val next = temp.next
            temp.next = null
            addElementToFirst(temp)

            temp = next
        }
    }

    fun getAtLastIndex(index: Int): Node? {
        var count = 0
        var temp: Node? = head.next
        var result: Node? = head.next

        while (temp != null) {
            if (count > index) {
                result = result!!.next
            }
            temp = temp.next
            count++
        }

        return result
    }

    fun getMiddleNode(): Node? {
        var temp: Node? = head.next
        var result: Node? = head.next

        while (temp != null && temp.next != null) {
            result = result?.next
            temp = temp.next?.next
        }

        return result
    }

    fun getLastNode(): Node? {
        var temp: Node? = head
        while (temp != null && temp.next != null) {
            temp = temp.next
        }
        return temp
    }

    fun hasLoop(): Boolean {
        var temp: Node? = head.next
        var result: Node? = head.next

        while (temp != null && temp.next != null) {
            result = result?.next
            temp = temp.next?.next

            if (temp === result) {
                return true
            }
        }

        return false;
    }

    fun hasCrossTo(chain: Chain): Boolean {
        return getLastNode() === chain.getLastNode()
    }

    fun getLength(): Int {
        var count = 0
        var temp: Node? = head

        while (temp != null) {
            temp = temp.next
            count++
        }

        return count
    }

    fun getFirstCrossNodeTo(chain: Chain): Node? {
        if (hasCrossTo(chain)) {
            val distance = getLength() - chain.getLength()

            var temp1: Node? = head
            var temp2: Node? = chain.head

            if (distance > 0) {
                for (count in 0 until distance) {
                    temp1 = temp1!!.next
                }
            }

            if (distance < 0) {
                for (count in distance until 0) {
                    temp2 = temp2!!.next
                }
            }

            while (temp1!!.next != null && temp2!!.next != null) {
                if (temp1 === temp2) {
                    return temp1
                }

                temp1 = temp1.next
                temp2 = temp2.next
            }

            return null

        } else {
            return null
        }
    }

    fun log() {
        if (hasLoop()) {
            println("can't log when it's a loop and did'nt come back to head\n")
            return
        }

        var temp: Node? = head
        while (temp != null) {
            print("${temp.content} -> ")
            temp = temp.next
        }
        println("\n")
    }
}