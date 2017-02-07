package queue

/**
 * Created by zhangll on 2017/2/6.
 */
fun main(args: Array<String>) {

    // 队列演示
    val queue = Queue()
    queue.log()

    // 入列
    println("put 1 in")
    queue.put("1")
    queue.log()

    // 出列
    println("pop")
    val p = queue.pop()
    println("pop string: $p")
    queue.log()

    // 链表队列演示
    val chainQueue = ChainQueue()
    chainQueue.log()

    // 入列
    println("put 1 in")
    chainQueue.put("1")
    chainQueue.log()

    println("put 1 in")
    chainQueue.put("2")
    chainQueue.log()

    // 出列
    println("pop")
    val node = chainQueue.pop()
    println("pop node: ${node?.content}")
    chainQueue.log()
}