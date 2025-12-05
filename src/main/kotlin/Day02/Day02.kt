package Day02

import java.io.File

fun main() {
    println(sumInvalidIds())
}

fun sumInvalidIds(): Long {
    val filePath = "src/day_02_input.txt"

    val fileContent: String = File(filePath).readText().trim()

    val idPairArray: List<String> = fileContent.split(",").filter { it.isNotBlank() }

    var total: Long = 0

    for (idPair in idPairArray) {
        val pairArray: List<String> = idPair.split("-")

        val lowerBound = pairArray[0].toLong()
        val upperBound = pairArray[1].toLong()

        for (num in lowerBound..upperBound) {
            val numString = num.toString()
            val length = numString.length

            if (length % 2 == 0) {
                val halfLength = length / 2

                val firstHalf = numString.take(halfLength)

                val secondHalf = numString.substring(halfLength)

                if (firstHalf == secondHalf) {
                    total += num
                }
            }
        }
    }
    return total
}