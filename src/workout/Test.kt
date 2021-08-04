package workout

import java.io.File




fun main() {

//    val string = """
//        请你务必审慎阅读、充分理解"救驾侠软件许可及服务协议"各条款，包括但不限于：为了向你提供紧急救援等服务，我们需要收集你的设备信息、操作日志等个人信息。
//        你可以阅读《救驾侠软件许可及服务协议》了解详细信息。如你同意，请点击"同意"开始接受我们的服务。
//        """.trimIndent()
//
//    println(string.indexOf("》"))




    var fileName = "/Users/zhangll/Library"
    val children = File(fileName).listFiles()

    val start = System.nanoTime()
    val total = children.map {
        if (it.name.contains("Containers")) return@map 0L

        val size = getTotalSizeOfFilesInDir(it)
        if (size > 1000 * 1000 * 100)
            println("${it.name} size: ${size.toFloat() / 1000 / 1000} MB")
        size
    }.sum()
    val end = System.nanoTime()
    println("Total Size: ${total / 1000 / 1000} MB")
    println("Time taken: " + (end - start) / 1.0e9)
}

// 递归方式 计算文件的大小
private fun getTotalSizeOfFilesInDir(file: File): Long {
    if (file.isFile) return file.length()
    val children = file.listFiles()
    var total: Long = 0
    if (children != null) for (child in children) total += getTotalSizeOfFilesInDir(child)
    return total
}