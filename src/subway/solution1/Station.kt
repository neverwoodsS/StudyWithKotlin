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

    fun pathTo(station: Station, lines: MutableSet<TrainLine> = mutableSetOf(), deep: Int = 0): MutableList<MutableList<Pair<Station, TrainLine>>?>? {
        // 限制换乘次数
        if (deep > 2) {
            return null
        }

        val mins = mutableListOf<MutableList<Pair<Station, TrainLine>>?>()
        var minSize = 25

        if (isDirectArrive(station)) {
            var temp: MutableList<Pair<Station, TrainLine>>

            throughLines
                    .filter { it.stations.contains(station) }
                    .forEach {
                        temp = it.getPathBetween(this@Station, station)

                        if (temp.size == minSize) {
                            mins.add(temp)
                        } else if (temp.size < minSize) {
                            minSize = temp.size
                            mins.add(temp)
                        }
                    }
            return mins

        } else {
            var tempLines = mutableSetOf<TrainLine>()
            lines.forEach { tempLines.add(it) }

            for (throughLine in throughLines) {
                if (!tempLines.contains(throughLine)) {
                    for (changeStation in throughLine.changeStations) {
                        if (changeStation != this) {

                            val newLines = mutableSetOf<TrainLine>()
                            tempLines.forEach { newLines.add(it) }
                            newLines.add(throughLine)

                            val changeList = throughLine.getPathBetween(this, changeStation)
                            val deepList = changeStation.pathTo(station, newLines, deep + 1)

                            if (deepList == null || deepList.isEmpty()) {
                                continue
                            }

                            val size = changeList.size + deepList[0]!!.size

                            if (size == minSize) {
                                deepList.forEach {
                                    val list = mutableListOf<Pair<Station, TrainLine>>()
                                    list.addAll(changeList)
                                    list.addAll(it!!)
                                    mins.add(list)
                                }
                            } else if (size < minSize) {
                                // 先清除
                                mins.clear()
                                minSize = size

                                deepList.forEach {
                                    val list = mutableListOf<Pair<Station, TrainLine>>()
                                    list.addAll(changeList)
                                    list.addAll(it!!)
                                    mins.add(list)
                                }
                            }
                        }
                    }
                    tempLines.add(throughLine)
                }
                tempLines = lines
            }

            return mins
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