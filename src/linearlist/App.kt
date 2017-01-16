package linearlist

/**
 * Created by zhangll on 2017/1/16.
 */
fun main(args: Array<String>) {

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




    println("start chain")
    val chain = Chain()
    println("init: ")
    chain.log()

    chain.addElementToLast(Chain.Node("last"))
    println("add last: ")
    chain.log()

    chain.addElementToFirst(Chain.Node("first"))
    println("add first: ")
    chain.log()

    chain.deleteFirst()
    println("delete first: ")
    chain.log()

    chain.deleteLast()
    println("delete last: ")
    chain.log()

    chain.addElementToIndex(Chain.Node("index"), 2)
    println("add at 2: ")
    chain.log()

    chain.deleteAtIndex(2)
    println("delete at 2: ")
    chain.log()

    chain.deleteAtIndex(4)
    println("delete at 4: ")
    chain.log()

    println("end chain")
}