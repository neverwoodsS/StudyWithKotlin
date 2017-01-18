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
    println("${middleNode?.content}")

    // 判断是否有循环
    node5.next = node6
    chain.addElementToLast(node5)
    chain.reserve()
    chain.addElementToLast(node6)
    chain.log()
}