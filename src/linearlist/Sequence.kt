package linearlist

/**
 * Created by zhangll on 2017/1/16.
 */
class Sequence {
    var array: Array<String> = arrayOf("false", "false", "false", "false", "false")

    fun addElement(element: String, position: Int) {
        val temp: Array<String> = Array(array.size + 1, { "temp" })

        // 插入位置前的参数不变， 插入位置的参数取插入数值，插入位置后的参数取前一位对应参数
        (0..array.size).forEach {
            temp[it] = when(it) {
                in 0 until position -> array[it]
                position -> element
                in position + 1..array.size -> array[it - 1]
                else -> throw Exception("wrong")
            }
        }

        array = temp
    }

    fun deleteElement(position: Int) {
        val temp: Array<String> = Array(array.size - 1, { "temp" })

        // 删除位置前的参数不变，删除位置开始取后一位参数
        (0..array.size - 2).forEach {
            temp[it] = when(it) {
                in 0 until position -> array[it]
                in position .. array.size - 2 -> array[it + 1]
                else -> throw Exception("wrong")
            }
        }

        array = temp
    }

    fun log() {
        (0 until array.size).map { array[it] }.forEach { print(it + ", ") }
        println()
    }
}