package study

import java.util.*

/**
 * Created by zhangll on 2018/1/22.
 */
fun main(args: Array<String>) {
//    Bird(Wing()).fly()

//    val b1 = Bird(Wing())
//    val b2 = Bird(Wing())
//    val b3 = b1 + b2
    val (a, b) = A("this is A") to B("this is B") // Pair(A(), B())
    println(a)
    println(b)

    val list = listOf("1")

    for (string in list) {

    }

    list.forEach {

    }
}

data class Group(val a: A, val b: B)
data class A(val content: String) {
    fun testA() {
        println("test A")
    }
}
data class B(val content: String)