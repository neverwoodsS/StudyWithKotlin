package linearlist

/**
 * Created by zhangll on 2017/1/18.
 */
fun main(args: Array<String>) {

    // 以最快速度删除链表中节点
    // 原理是用下一个节点的数据覆盖当前节点，再删除下一节点
    // 如此无需拥有上一节点的实例或指针
    // 但对末尾节点不能采用这种方法
    val chain = Chain()
    println("init: ")
    chain.log()

    val node5 = Node("5")
    val node6 = Node("6")

    println("add 5,6: ")
    chain.addElementToLast(node5)
    chain.addElementToLast(node6)
    chain.log()

    println("delete 5")
    chain.deleteNode(node5)
    chain.log()

    println("delete 6")
    chain.deleteNode(node6)
    chain.log()

    // 反转链表
    println("reserve")
    chain.reserve()
    chain.log()

    // 获取倒数第二个节点
    println("get last 2 node")
    val node = chain.getAtLastIndex(2)
    println("${node?.content}")

    // 获取中间节点
    println("get middle node")
    val middleNode = chain.getMiddleNode()
    println("${middleNode?.content}\n")

    // 判断是否有循环
    println("judge loop: ")
    node5.content = "5"
    node6.next = node5
    chain.addElementToLast(node5)
    chain.reserve()
    chain.addElementToLast(node6)
    chain.log()

    // 拆掉循环
    println("delete loop: ")
    node6.next = null
    chain.deleteNode(node6)
    chain.log()
    chain.deleteNode(node5)
    chain.log()
    println("node5.content = ${node5.content}")
    println("PS.由此可见 delete directly 虽然降低了时间复杂度，但会在一定程度上造成混乱\n")

    // 判断两个链表是否相交
    println("judge cross\n")
    val chain2 = Chain()
    val crossNode = Node("cross")
    chain.addElementToIndex(crossNode, 2)
    chain2.addElementToIndex(crossNode, 3)

    println("chain:")
    chain.log()
    println("chain2: ")
    chain2.log()
    println("crossed = ${chain.hasCrossTo(chain2)}")

    println("first cross node = ${chain.getFirstCrossNodeTo(chain2)?.content}")
}