package stack

/**
 * Created by zhangll on 2017/2/10.
 */
fun main(args: Array<String>) {
    // 栈演示
    val stack = Stack()
    stack.log()

    // 入栈
    println("put 1 in")
    stack.put("1")
    stack.log()

    // 出栈
    println("pop")
    val pop = stack.pop()
    println("pop $pop")
    stack.log()

    // 链栈演示
    val chainStack = ChainStack()
    chainStack.log()

    // 入栈
    println("put 1 in")
    chainStack.put("1")
    chainStack.log()

    println("put 2 in")
    chainStack.put("2")
    chainStack.log()

    println("put 3 in")
    chainStack.put("3")
    chainStack.log()

    // 出栈
    println("pop")
    val chainPop = chainStack.pop()
    println("pop ${chainPop?.content}")
    chainStack.log()
}