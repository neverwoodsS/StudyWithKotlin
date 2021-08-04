package workout

/**
 * Created by zhangll on 2018/6/6.
 */
fun main(args: Array<String>) {
    test(5)
}

fun test(n: Int) {
    move(n, 1, 2, 3)
}

/**
 * 按顺序将size 个块从 from 通过 pass 移动到 target 柱子
 */
fun move(size: Int, from: Int, pass: Int, target: Int) {
    val sizeChar = (size + 64).toChar()

    if (size == 1) {
        println("move $sizeChar from $from to $target")
    } else {
        move(size - 1, from, target, pass)
        println("move $sizeChar from $from to $target")
        move(size - 1, pass, from, target)
    }
}