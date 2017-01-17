package linearlist

/**
 * Created by zhangll on 2017/1/16.
 */
fun main(args: Array<String>) {

    // 数组

    println("start sequence")
    val sequence = Sequence()
    print("init: ")
    sequence.log()

    sequence.addElement("true", 3)
    println("add at 3: ")
    sequence.log()

    sequence.addElement("true", 2)
    println("add at 2: ")
    sequence.log()

    sequence.deleteElement(2)
    println("delete at 2: ")
    sequence.log()

    println("end sequence\n")


    // 单链表

    println("start chain")
    val chain = Chain()
    println("init: ")
    chain.log()

    chain.addElementToLast(Node("last"))
    println("add last: ")
    chain.log()

    chain.addElementToFirst(Node("first"))
    println("add first: ")
    chain.log()

    chain.deleteFirst()
    println("delete first: ")
    chain.log()

    chain.deleteLast()
    println("delete last: ")
    chain.log()

    chain.addElementToIndex(Node("index"), 2)
    println("add at 2: ")
    chain.log()

    chain.deleteAtIndex(2)
    println("delete at 2: ")
    chain.log()

    chain.deleteAtIndex(4)
    println("delete at 4: ")
    chain.log()

    println("end chain\n")


    // 循环单链

    println("start loop chain")
    val loopChain = LoopChain()
    println("init: ")
    loopChain.log()

    loopChain.addToFirst(Node("first"))
    println("add to first: ")
    loopChain.log()

    loopChain.addToLast(Node("last"))
    println("add to last")
    loopChain.log()

    loopChain.removeLast()
    println("remove last")
    loopChain.log()

    loopChain.removeFirst()
    println("remove first")
    loopChain.log()

    val node = Node("node")
    val test = Node("test")

    loopChain.addToLast(node)
    println("add node: ")
    loopChain.log()

    println("remove node: ")
    loopChain.removeNode(node)
    loopChain.log()

    println("remove test: ")
    loopChain.removeNode(test)
    loopChain.log()

    println("remove at index: 3")
    loopChain.removeAtIndex(3)
    loopChain.log()

    println("remove at index: 4")
    loopChain.removeAtIndex(4)
    loopChain.log()

    println("add at index: 0")
    loopChain.addToIndex(Node("0"), 0)
    loopChain.log()

    println("add at index: 6")
    loopChain.addToIndex(Node("3"), 6)
    loopChain.log()
}