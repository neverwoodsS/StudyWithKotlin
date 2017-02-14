package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
class TrainLine(val name: String) {
    // 线路经过的所有站点集合
    val stations = linkedSetOf<Station>()

    // 线路经过的所有 换乘点 集合
    val changeStations = linkedSetOf<Station>()

    /* 将站点添加至线路中
     * stationName: 站名
     */
    fun putStation(stationName: String) {
        val station = StationPool.getStation(stationName)
        // station 与 trainLine 互相添加引用
        station.throughLines.add(this)
        stations.add(station)

        // 若站点不止一条线路，则将站点作为换乘站标记在途径线路上
        if (station.throughLines.size > 1) {
            station.throughLines.forEach {
                it.putChangeStation(station)
            }
        }
    }

    /**
     * 添加换乘站
     */
    fun putChangeStation(station: Station) {
        changeStations.add(station)
    }

    /**
     * 计算线路上两个站之间的距离
     */
    fun countDistance(station1: Station, station2: Station): Int {
        var index1: Int? = null
        var index2: Int? = null

        stations.forEachIndexed { index, station ->
            if (station === station1) {
                index1 = index
            }

            if (station === station2) {
                index2 = index
            }
        }

        if (index1 == null || index2 == null) {
            throw Exception("下标计算异常")
        }

        return Math.abs(index1!! - index2!!)
    }

    /**
     * 获取线路上两个站点之间的路径
     * station1: 出发点
     * station2: 目的点
     * return: station-line 的 键值对 的集合，不直接用 station 集合是因为需要有 line 数据显示
     */
    fun getPathBetween(station1: Station, station2: Station): MutableList<Pair<Station, TrainLine>> {
        val result = mutableListOf<Pair<Station, TrainLine>>()
        val index1 = stations.indexOf(station1)
        val index2 = stations.indexOf(station2)

        if (index1 > index2) {
            (index1 downTo index2).forEach {
                result.add(stations.elementAt(it) to this)
            }
        } else if (index1 < index2) {
            (index1 .. index2).forEach {
                result.add(stations.elementAt(it) to this)
            }
        } else { // 理论上不会出现
            stations.elementAt(index1)
        }

        return result
    }
}