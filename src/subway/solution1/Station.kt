package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
class Station(val name: String) {
    val throughLines = mutableListOf<TrainLine>()

    fun farFrom(station: Station, lines: MutableSet<TrainLine> = mutableSetOf(), deep: Int = 0): Int {
        // 限制换乘次数
        if (deep > 2) {
            return Int.MAX_VALUE
        }

        if (isDirectArrive(station)) {
            var min = 25
            throughLines
                    .filter { it.stations.contains(station) }
                    .forEach {
                        val distance = it.countDistance(this, station)
                        if (distance < min) {
                            min = distance
                        }
                    }
            return min

        } else {
            var min = 25

            var tempLines = mutableSetOf<TrainLine>()
            lines.forEach { tempLines.add(it) }

            for (throughLine in throughLines) {
                if (!tempLines.contains(throughLine)) {
                    for (changeStation in throughLine.changeStations) {
                        if (changeStation != this) {
//                            lines.add(throughLine)

                            val newLines = mutableSetOf<TrainLine>()
                            tempLines.forEach { newLines.add(it) }
                            newLines.add(throughLine)

                            val changeDistance = throughLine.countDistance(this, changeStation)
                            val deepDistance = changeStation.farFrom(station, newLines, deep + 1)

                            if (deepDistance >= Int.MAX_VALUE) {
                                continue
                            }

                            val distance = changeDistance + deepDistance
                            if (distance < min) {
                                min = distance
                            }
                        }
                    }
                    tempLines.add(throughLine)
                }
                tempLines = lines
            }

            return min
        }
    }

    fun isDirectArrive(station: Station): Boolean {
        throughLines
                .filter { it.stations.contains(station) }
                .forEach {
                    return true
        }

        return false
    }
}