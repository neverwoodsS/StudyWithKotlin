package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
class TrainLine(val name: String) {
    val stations = linkedSetOf<Station>()
    val changeStations = linkedSetOf<Station>()

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

    fun putChangeStation(station: Station) {
        changeStations.add(station)
    }

    fun countDistance(station1: Station, station2: Station): Int {
        var index1: Int = -1
        var index2: Int = -1

        stations.forEachIndexed { index, station ->
            if (station === station1) {
                index1 = index
            }

            if (station === station2) {
                index2 = index
            }
        }

        if (index1 == -1 || index2 == -1) {
            throw Exception("下标计算异常")
        }

        return Math.abs(index1 - index2)
    }

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
        } else {
            stations.elementAt(index1)
        }

        return result
    }
}