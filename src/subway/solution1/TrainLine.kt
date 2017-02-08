package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
class TrainLine {
    val stations = linkedSetOf<Station>()
    val changeStations = linkedSetOf<Station>()

    fun putStation(station: Station) {
        stations.add(station)
    }

    fun putStation(stationName: String) {
        val station = StationPool.getStation(stationName)
        // station 与 trainLine 互相添加引用
        station.throughLine.add(this)
        stations.add(station)

        // 若站点不止一条线路，则将站点作为换乘站标记在途径线路上
        if (station.throughLine.size > 1) {
            station.throughLine.forEach {
                it.putChangeStation(station)
            }
        }
    }

    fun putChangeStation(station: Station) {
        changeStations.add(station)
    }

    fun log() {
        println("stations: ")
        stations.forEach { print("${it.name}, ") }
        println()

        println("changeStations: ")
        changeStations.forEach { print("${it.name}, ") }
        println()
        println()
        println()
    }
}