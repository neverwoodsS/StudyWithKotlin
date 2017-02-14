package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
class Station(val name: String) {
    val throughLines = mutableListOf<TrainLine>()

    /**
     * 计算两个站点之间的距离
     * station: 目标站
     * lines: 已经走过的路线
     * deep: 递归深度(换乘次数)
     */
    fun farFrom(station: Station, lines: MutableSet<TrainLine> = mutableSetOf(), deep: Int = 0): Int {
        // 限制换乘次数
        if (deep > 2) {
            return Int.MAX_VALUE
        }

        if (isDirectArrive(station)) {
            // 在同一条线路上则直接计算距离
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

            // 遍历经过当前站点的线路
            for (throughLine in throughLines) {

                // 排除掉已经走过的线路，避免无限换乘
                if (!tempLines.contains(throughLine)) {

                    // 遍历线路上的所有换乘点
                    for (changeStation in throughLine.changeStations) {

                        // 排除掉通过自身换乘的情景
                        if (changeStation != this) {

                            val newLines = mutableSetOf<TrainLine>()
                            tempLines.forEach { newLines.add(it) }
                            newLines.add(throughLine)

                            // 计算当前站点到所选换乘点需要经过的距离
                            val changeDistance = throughLine.countDistance(this, changeStation)

                            // 计算换乘点到目标点的距离
                            // 通过调用方法自身实现递归遍历
                            val deepDistance = changeStation.farFrom(station, newLines, deep + 1)

                            if (deepDistance >= Int.MAX_VALUE) {
                                continue
                            }

                            // 发现了更近的距离则保存
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

    /**
     * 获取两个站点之间的最短路径 的集合
     * station: 目标站
     * lines: 已经走过的路线
     * deep: 递归深度(换乘次数)
     */
    fun pathTo(station: Station, lines: MutableSet<TrainLine> = mutableSetOf(), deep: Int = 0): MutableList<MutableList<Pair<Station, TrainLine>>?>? {
        // 限制换乘次数
        if (deep > 2) {
            return null
        }

        // 用于保存所有距离最近的路线
        val mins = mutableListOf<MutableList<Pair<Station, TrainLine>>?>()
        var minSize = 25

        if (isDirectArrive(station)) {
            var temp: MutableList<Pair<Station, TrainLine>>

            throughLines
                    .filter { it.stations.contains(station) }
                    .forEach {
                        temp = it.getPathBetween(this@Station, station)

                        // 如果距离等于当前最小距离，共存
                        if (temp.size == minSize) {
                            mins.add(temp)
                        // 如果距离小于当前最小距离，清除先前数据再保存
                        } else if (temp.size < minSize) {
                            minSize = temp.size
                            mins.clear()
                            mins.add(temp)
                        }
                    }
            return mins

        } else {
            var tempLines = mutableSetOf<TrainLine>()
            lines.forEach { tempLines.add(it) }

            // 遍历经过当前站点的线路
            for (throughLine in throughLines) {

                // 排除掉已经走过的线路，避免无限换乘
                if (!tempLines.contains(throughLine)) {

                    // 遍历线路上的所有换乘点
                    for (changeStation in throughLine.changeStations) {

                        // 排除掉通过自身换乘的情景
                        if (changeStation != this) {

                            val newLines = mutableSetOf<TrainLine>()
                            tempLines.forEach { newLines.add(it) }
                            newLines.add(throughLine)

                            // 获取当前站到换乘站的路径
                            val changeList = throughLine.getPathBetween(this, changeStation)

                            // 获取换乘站到目标站点的最短路径集合
                            // 递归实现
                            val deepList = changeStation.pathTo(station, newLines, deep + 1)

                            // 排除异常情况
                            if (deepList == null || deepList.isEmpty()) {
                                continue
                            }

                            // 计算总距离
                            val size = changeList.size + deepList[0]!!.size

                            // 如果距离等于当前最小距离，共存
                            // 如果距离小于当前最小距离，清除先前数据再保存
                            if (size <= minSize) {
                                if (size < minSize) {
                                    // 先清除
                                    mins.clear()
                                    minSize = size
                                }

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

    /**
     * 判断某站和当前站点是否在同一条线路上
     */
    fun isDirectArrive(station: Station): Boolean {
        throughLines
                .filter { it.stations.contains(station) }
                .forEach {
                    return true
        }

        return false
    }
}