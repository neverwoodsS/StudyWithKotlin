package workout

import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.net.URLConnection

fun main() {
    val path = "/Users/zhangll/Downloads/世青"

    val baseUrls = arrayOf(
            "https://www.manhuadb.com/manhua/238/222_2746.html" to 195
            ,
            "https://www.manhuadb.com/manhua/238/222_2744.html" to 199,
            "https://www.manhuadb.com/manhua/238/222_2740.html" to 199,
            "https://www.manhuadb.com/manhua/238/222_2743.html" to 195,
            "https://www.manhuadb.com/manhua/238/222_2731.html" to 209,
            "https://www.manhuadb.com/manhua/238/222_2738.html" to 203,
            "https://www.manhuadb.com/manhua/238/222_2745.html" to 201,
            "https://www.manhuadb.com/manhua/238/222_2739.html" to 207,
            "https://www.manhuadb.com/manhua/238/222_2732.html" to 205,
            "https://www.manhuadb.com/manhua/238/222_2736.html" to 187,
            "https://www.manhuadb.com/manhua/238/222_2735.html" to 195,
            "https://www.manhuadb.com/manhua/238/222_2747.html" to 199,
            "https://www.manhuadb.com/manhua/238/222_2748.html" to 183,
            "https://www.manhuadb.com/manhua/238/222_2733.html" to 183,
            "https://www.manhuadb.com/manhua/238/222_2741.html" to 187,
            "https://www.manhuadb.com/manhua/238/222_2737.html" to 189,
            "https://www.manhuadb.com/manhua/238/222_2742.html" to 191,
            "https://www.manhuadb.com/manhua/238/222_2734.html" to 205
    )

    baseUrls.forEachIndexed { index, pair ->
        val folder = File("$path/${index + 1}")
        if (!folder.exists()) folder.mkdirs()

        val (baseUrl, size) = pair
        (1..size).forEach {
            val file = File(folder,"$it.jpg")
            if (file.exists()) return@forEach

            val url = baseUrl.replace(".html", "_p$it.html")
            val string = URL(url).readText()

            if (!string.contains("<img class=\"img-fluid show-pic\" src=\"")) {
                println("缺少当前页:${index+1}-$it, url=$url")
                return@forEach
            }
            val pic = string.split("<img class=\"img-fluid show-pic\" src=\"")[1].split("\" />")[0]

            val input = URL(pic).openConnection().apply {
                setRequestProperty("User-Agent", "Mozilla/5.0")
            }.getInputStream()

            val output = FileOutputStream(file)

            var j = 0
            do {
                j = input.read()
                output.write(j)
            } while (j != -1)

            output.close()
        }
    }
}