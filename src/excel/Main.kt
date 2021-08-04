package excel

import java.io.FileInputStream
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell

/**
 * Created by zhangll on 2017/4/9.
 */
fun main(args: Array<String>) {
    val firstData = getFirstData("/Users/zhangll/Desktop/nana/201703收款单上海.xls")
    val secondData = getSecondData("/Users/zhangll/Desktop/nana/泵业银行明细表0301-0331.xls")

    val result = compare(firstData, secondData, "first")
    result.addAll(compare(secondData, firstData, "second"))

    result.forEach { println(it) }
}

private fun compare(first: List<Data>, second: List<Data>, tag: String): MutableList<Compare> {
    val list = mutableListOf<Compare>()

    for (data1 in first) {
        var count = 0

        for (data2 in second) {
            if (data1 == data2) {
                count++
            }
        }

        val data = when(count) {
            0 -> Compare(data1.date, data1.company, data1.money, "在${tag}中出现独立内容")
            in 2 .. Int.MAX_VALUE -> Compare(data1.date, data1.company, data1.money, "内容重复，需手动检查")
            else -> null
        }

        if (data != null && !contain(list, data)) {
            list.add(data)
        }
    }

    return list
}

private fun contain(list: MutableList<Compare>, compare: Compare): Boolean {
    for (data in list) {
        if (data.company == compare.company && data.date == compare.date && data.money == compare.money && data.content == compare.content) {
            return true
        }
    }

    return false
}

private fun getFirstData(filePath: String): List<Data> {
    val fis = FileInputStream(filePath)
    //根据上述创建的输入流 创建工作簿对象
    val wb = HSSFWorkbook(fis)
    //得到第一页 sheet
    //页Sheet是从0开始索引的
    val sheet = wb.getSheetAt(0)

    fis.close()

    return sheet.flatMap { it }
            .map { data -> data.row }
            .filter { it.getCell(0).stringCellValue != "合计" && it.getCell(6).cellType == Cell.CELL_TYPE_NUMERIC }
            .map {
                val date = it.getCell(1)
                val company = it.getCell(2)
                val money = it.getCell(6)

                if (date == null || company == null || money == null) {
                    println("find a null data: ${it.getCell(0)}, $date, $company, $money")
                    null
                } else {
                    Data(date.stringCellValue.replace("-", ""), company.stringCellValue, money.numericCellValue)
                }
            }
            .filter { it != null }
            .map { it as Data }
}

private fun getSecondData(filePath: String): List<Data> {
    val fis = FileInputStream(filePath)
    //根据上述创建的输入流 创建工作簿对象
    val wb = HSSFWorkbook(fis)
    //得到第一页 sheet
    //页Sheet是从0开始索引的
    val sheet = wb.getSheetAt(0)

    fis.close()

    return sheet.flatMap { it }
            .map { data -> data.row }
            .filter { it.getCell(0).stringCellValue != "合计"
                    && it.lastCellNum >= 2
                    && it.getCell(2).cellType == Cell.CELL_TYPE_NUMERIC }
            .map {
                val date = it.getCell(0)
                val company = it.getCell(11)
                val money = it.getCell(2)

                if (date == null || company == null || money == null) {
                    println("find a null data: ${it.getCell(0)}, $date, $company, $money")
                    null
                } else {
                    Data(date.stringCellValue, company.stringCellValue, money.numericCellValue)
                }
            }
            .filter { it != null }
            .map { it as Data }
}

open private class Data(open val date: String, open val company: String, open val money: Double) {
    override fun toString(): String {
        return "Data(date='$date', company='$company', money=$money)"
    }
}

private class Compare(override val date: String, override val company: String, override val money: Double, val content: String) : Data(date, company, money) {
    override fun toString(): String {
        return "Compare(date='$date', company='$company', money=$money, content='$content')"
    }
}