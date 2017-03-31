package workout

/**
 * Created by zhangll on 2017/2/16.
 */
fun main(args: Array<String>) {
    jump(4)
}

fun jump(leftover: Int) {
    when(leftover) {
        0 -> println("it's over")
        1 -> jump(0)
        else -> {
            jump(leftover - 1)
            jump(leftover - 2)
        }
    }
}