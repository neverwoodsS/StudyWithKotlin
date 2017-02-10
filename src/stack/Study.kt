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
}