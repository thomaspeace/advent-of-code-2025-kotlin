package Day03

import java.io.File
import kotlin.math.max

fun main() {
    println(getTotalJoltage())
}

fun getTotalJoltage(): Int {
    val filePath = "src/day_03_input.txt"
    val batteryPacks = getBatteryPacksFromFile(filePath)
    println(batteryPacks)
    var totalJoltage: Int = 0
    for (batteryPack in batteryPacks) {
        totalJoltage += getBiggestBattery(batteryPack)
    }
    return totalJoltage
}

fun getBatteryPacksFromFile(filePath: String): MutableList<String> {
    val batteryPacks = mutableListOf<String>()
    File(filePath).forEachLine { line ->
        if (line.isNotEmpty()) {
            val batteryPack: String = line
            batteryPacks.add(batteryPack)
        }
    }
    return batteryPacks
}

fun getBiggestBattery(batteryPack: String): Int {
    var maximumJoltage: Int = Int.MIN_VALUE
    var largestDigitSeen: Int = batteryPack[0].digitToInt()
    for (i in 1..batteryPack.lastIndex) {
        maximumJoltage = max(
            maximumJoltage,
            (largestDigitSeen * 10) + batteryPack[i].digitToInt()
        )
        largestDigitSeen = max(largestDigitSeen, batteryPack[i].digitToInt())
    }
    return maximumJoltage
}


