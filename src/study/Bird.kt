package study

/**
 * Created by zhangll on 2018/1/22.
 */
class Bird(val wing: Wing) : Flyable by wing {
    override fun fly() {
        println("override fly")
    }

    operator fun plus(other: Bird): String {
        return toString() + other.toString()
    }
}