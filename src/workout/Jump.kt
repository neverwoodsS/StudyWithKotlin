package workout

import java.net.URL

/**
 * Created by zhangll on 2017/2/16.
 */
fun main(args: Array<String>) {
    // TODO
    test()
//    Test().test()
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

fun test() {

}

class User {
    var inn: Inner

    init {
        inn = Inner("zhangll")
    }

    fun test() {
        println(inn)
    }
}

data class Inner(var name: String)