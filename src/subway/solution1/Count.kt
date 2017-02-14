package subway.solution1

/**
 * Created by zhangll on 2017/2/13.
 */
fun main(args: Array<String>) {
    // 这句只是为了初始化一下数据
    StationData.trainLines.forEach {  }

    println("distance = ${ StationPool.getStation("黄兴公园").farFrom(StationPool.getStation("虹桥火车站")) }")
}