package study

/**
 * Created by zhangll on 2018/1/22.
 */
class Wing : Flyable {
    override fun stop() {
        println("stop by wing")
    }

    override fun fly() {
        println("fly by wing")
    }
}