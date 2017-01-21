package linearlist

/**
 * Created by zhangll on 2017/1/21.
 */
class DoubleChain {
    val head by lazy { DoubleNode("head") }
    val prior by lazy { DoubleNode("prior") }

    init {
        head.next = prior
        prior.last = head

        for (i in 0..4) {
//            addElementToFirst(DoubleNode(i.toString()))
            addElementToLast(DoubleNode(i.toString()))
        }
    }

    fun addElementToFirst(element: DoubleNode) {
        element.next = head.next
        head.next!!.last = element

        element.last = head
        head.next = element
    }

    fun addElementToLast(element: DoubleNode) {
        element.last = prior.last
        prior.last!!.next = element

        element.next = prior
        prior.last = element
    }

    fun log() {
        var temp: DoubleNode? = head
        while (temp != null) {
            print("${temp.content} -> ")
            temp = temp.next
        }
        println("\n")
    }
}