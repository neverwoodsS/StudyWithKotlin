package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
fun main(args: Array<String>) {
    // 这句只是为了初始化一下数据
    StationData.trainLines.forEach {  }

    val accept = 8

    val stations = mutableListOf(
             "南浦大桥"
            ,"蓝村路"
            ,"西藏北路"
            ,"昌平路"
            ,"张江高科"
            ,"天潼路"
    ).map { StationPool.getStation(it) }


    // 针对每个 target 计算符合条件的站点并收集为集合
    val lists = stations.map { target -> StationPool.pool.map { it.value }.filter { it.farFrom(target) <= accept }.toList() }

    // 筛选对所有 target 都符合条件的站点
    var list = lists[0]
    val all = lists.subList(1, lists.size)
    all.forEach {
        list = list.retain(it)
    }

    // 输出日志
    println("满足条件的站点共有 ${list.size} 个")
    list.forEach { station ->
        println("${station.name}:")
        stations.forEach { target ->
            println("${station.farFrom(target)} stations from ${target.name}")
        }
        println()
    }
}

fun <E> List<E>.retain(list: List<E>): List<E> {
    val result = mutableListOf<E>()

    filter { list.contains(it) }.forEach {
        result.add(it)
    }

    return result
}