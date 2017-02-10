package stack

/**
 * Created by zhangll on 2017/2/10.
 */
class Stack {
    var array: Array<String> = arrayOf("false", "false", "false", "false", "false")

    fun put(element: String) {
        val temp: Array<String> = Array(array.size + 1, { "temp" })

        temp[0] = element
        (1 .. array.size).forEach {
            temp[it] = array[it - 1]
        }

        array = temp
    }

    fun pop(): String {
        if (array.isEmpty()) {
            throw Exception("empty!!")
        }

        val result = array[0]

        val temp: Array<String> = Array(array.size - 1, { "temp" })
        (0 until  array.size - 1).forEach {
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