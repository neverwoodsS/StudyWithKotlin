package logic

fun main(args: Array<String>) {
    val answers = arrayOf('a', 'b', 'c', 'd')

    (0 until 1024*1024).forEach {
        val tempAnswer = it.toAnswers()
        if (check(tempAnswer)) {
            val answer = tempAnswer.map { answers[it] }.joinToString(", ").toUpperCase()
            println(answer)
        }
    }
}

private fun check(answers: List<Int>): Boolean {

    val counts = (0..3).map { answer -> answers.count { answer == it } }
    val maxCount = counts.max() ?: 10
    val minCount = counts.min() ?: 0

    val answer1 = answers[0]
    val answer2 = answers[1]
    val answer3 = answers[2]
    val answer4 = answers[3]
    val answer5 = answers[4]
    val answer6 = answers[5]
    val answer7 = answers[6]
    val answer8 = answers[7]
    val answer9 = answers[8]
    val answer10 = answers[9]

    // 第一题的限制

    // 第二题的限制
    if (arrayOf(2,3,0,1)[answer2] != answer5)
        return false

    // 第三题的限制
    when (answer3) {
        0 -> if (!(answer6 == answer2 && answer6 == answer4)) return false
        1 -> if (answer6 == 1 || answer2 != 1 || answer4 != 1) return false
        2 -> if (answer6 != 2 || answer2 == 2 || answer4 != 2) return false
        3 -> if (answer6 != 3 || answer2 != 3 || answer4 == 3) return false
    }

    // 第四题的限制
    when (answer4) {
        0 -> if (answer1 != answer5) return false
        1 -> if (answer2 != answer7) return false
        2 -> if (answer1 != answer9) return false
        3 -> if (answer6 != answer10) return false
    }

    // 第五题的限制
    when (answer5) {
        0 -> if (answer8 != 0) return false
        1 -> if (answer4 != 1) return false
        2 -> if (answer9 != 2) return false
        3 -> if (answer7 != 3) return false
    }

    // 第六题限制
    when (answer6) {
        0 -> if (answer2 != answer8 || answer4 != answer8) return false
        1 -> if (answer1 != answer8 || answer6 != answer8) return false
        2 -> if (answer3 != answer8 || answer10 != answer8) return false
        3 -> if (answer5 != answer8 || answer9 != answer8) return false
    }

    // 第七题限制
    when (answer7) {
        0 -> if (counts[2] != minCount) return false
        1 -> if (counts[1] != minCount) return false
        2 -> if (counts[0] != minCount) return false
        3 -> if (counts[3] != minCount) return false
    }

    // 第八题限制
    val distance = arrayOf(answer7, answer5, answer2, answer10)[answer8] - answer1
    if (Math.abs(distance) <= 1) {
        return false
    }

    // 第九题限制
    val flag = answer1 == answer6
    val anotherFlag = arrayOf(answer6, answer10, answer2, answer9)[answer9] == answer5
    if (flag == anotherFlag) return false

    // 第十题限制
    if (arrayOf(3,2,4,1)[answer10] != maxCount - minCount) return false

    return true
}

private fun Int.toAnswers(): List<Int> {
    val temp = mutableListOf<Int>()
    var i = this
    while (i > 0) {
        temp.add(i % 4)
        i /= 4
    }

    val result: List<Int>
    if (temp.size < 10)
        result = temp + List(10 - temp.size) { 0 }
    else result = temp
    return result.reversed()
}