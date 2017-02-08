package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
object StationPool {
    private val pool = mutableMapOf<String, Station>()

    fun getStation(name: String): Station {
        if (pool.containsKey(name)) {
            return pool[name]!!
        } else {
            val station = Station(name)
            pool.put(name, station)
            return station
        }
    }
}