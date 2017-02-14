package subway.solution1

/**
 * Created by zhangll on 2017/2/13.
 */
fun main(args: Array<String>) {
    // 这句只是为了初始化一下数据
    StationData.trainLines.forEach {  }

    val path = StationPool.getStation("临平路").pathTo(StationPool.getStation("昌平路"))
    path?.forEach {
        println()
        it?.forEach {
            print("${ it.first.name }(${it.second.name}) -> ")
        }
        println("到达")

        println()
        println("或")
    }
    println()
    println("没了")
}