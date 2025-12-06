package Day02

import java.io.File

fun main() {
    println(sumInvalidIdsPartTwo())
}

fun sumInvalidIdsPartTwo(): Long {
    val filePath = "src/day_02_input.txt"

    val fileContent: String = File(filePath).readText().trim()

    val idPairArray: List<String> = fileContent.split(",").filter { it.isNotBlank() }

    var total: Long = 0

    for (idPair in idPairArray) {
        val pairArray: List<String> = idPair.split("-")

        val lowerBound = pairArray[0].toLong()
        val upperBound = pairArray[1].toLong()

        total += findInvalidIdsBetweenRange(lowerBound, upperBound)
    }
    return total
}

// I'm thinking that we can check every factor of the number and see if it repeats.
// for example, a number of length 8, we can check segments of 1, 2, and 4.
fun findInvalidIdsBetweenRange(lowerBound: Long, upperBound: Long): Long {
    var subTotal: Long = 0
    for (num in lowerBound..upperBound) {
        subTotal += checkNumIsValid(num)
    }
    return subTotal
}

fun checkNumIsValid(number: Long): Long {
    val segmentsToCheck: MutableList<Int> = mutableListOf<Int>()
    val numString = number.toString()
    for (divisor in 1 until numString.length) {
        if (numString.length % divisor == 0) segmentsToCheck.add(divisor)
    }
    for (divisor in segmentsToCheck) {
        if (isNumberInvalidAgainstDivisor(number, divisor)) return number
    }
    return 0
}

fun isNumberInvalidAgainstDivisor(number: Long, divisor: Int): Boolean {
    val numberString = number.toString()
    val segmentsNeeded = numberString.length / divisor
    val baseSegment = numberString.take(divisor)

    for (i in 1 until segmentsNeeded) {
        val currentSegment = numberString.substring(i * divisor, (i + 1) * divisor)
        if (currentSegment != baseSegment) return false
    }
    return true
}