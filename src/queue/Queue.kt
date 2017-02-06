package queue

/**
 * Created by zhangll on 2017/2/6.
 */
class Queue {
    var array: Array<String> = arrayOf("false", "false", "false", "false", "false")

    fun put(element: String) {
        val temp: Array<String> = Array(array.size + 1, { "temp" })

        (0 until array.size).forEach {
            temp[it] = array[it]
        }
        temp[array.size] = element

        array = temp
    }

    fun pop(): String {
        val result = array[0]
        val temp: Array<String> = Array(array.size - 1, { "temp" })

        (0 until array.size - 1).forEach {
            temp[it] = array[it + 1]
        }

        array = temp
        return result
    }

    fun log() {
        (0 until array.size).map { array[it] }.forEach { print(it + ", ") }
        println("\n")
    }
}