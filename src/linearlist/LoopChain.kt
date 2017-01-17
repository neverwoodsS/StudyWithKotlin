package linearlist

/**
 * Created by zhangll on 2017/1/17.
 */
class LoopChain {
    val head by lazy { Node("head") }

    init {
        head.next = head

        for (i in 0..4) {
            addToLast(Node(i.toString()))
        }
    }

    fun addToFirst(node: Node) {
        node.next = head.next
        head.next = node
    }

    fun addToLast(node: Node) {
        var temp: Node = head
        while (temp.next != head) {
            temp = temp.next!!
        }

        node.next = temp.next
        temp.next = node
    }

    fun addToIndex(element: Node, index: Int) {
        var temp: Node? = head
        var position = 0

        while (temp != null) {
            if (position == index) {
                element.next = temp.next
                temp.next = element
                break
            }

            temp = temp.next
            // 如果遇到 temp.next == head 的情况则再进一步，将 head 排除在计数以外
            if (temp!!.next == head) temp = temp.next
            position++
        }
    }

    fun removeFirst() {
        head.next = head.next!!.next
    }

    fun removeLast() {
        var temp: Node = head
        while (temp.next!!.next != head) {
            temp = temp.next!!
        }

        temp.next = temp.next!!.next
    }

    fun removeNode(node: Node) {
        var temp: Node = head
        while (temp.next != node) {
            if (temp.next == head) {
                println("i don't have this element")
                return
            }
            temp = temp.next!!
        }

        temp.next = node.next
    }

    fun removeAtIndex(index: Int) {
        var temp: Node? = head
        var position = 0

        while (temp != null) {
            if (position == index) {
                temp.next = temp.next!!.next
                break
            }

            temp = temp.next
            // 如果遇到 temp.next == head 的情况则再进一步，将 head 排除在计数以外
            if (temp!!.next == head) temp = temp.next
            position++
        }
    }

    fun log() {
        var temp: Node = head
        do {
            print("${temp.content} -> ")
            temp = temp.next!!
        } while (temp != head)
        print("${temp.content} -> ")

        println("\n")
    }
}