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

    fun log() {
        var temp: Node? = head
        while (temp != null) {
            print("${temp.content} -> ")
            temp = temp.next
        }
        println("\n")
    }
}