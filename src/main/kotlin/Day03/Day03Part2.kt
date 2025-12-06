package Day03

import java.io.File
import kotlin.math.max

fun main() {
    println(getTotalJoltagePart2())
}

fun getTotalJoltagePart2(): Int {
    val filePath = "src/day_03_input.txt"
    val batteryPacks = getBatteryPacksFromFilePart2(filePath)
    println(batteryPacks)
    var totalJoltage: Int = 0
    for (batteryPack in batteryPacks) {
        totalJoltage += getBiggestBatteryWithTwelveDigits(batteryPack)
    }
    return totalJoltage
}

fun getBatteryPacksFromFilePart2(filePath: String): MutableList<String> {
    val batteryPacks = mutableListOf<String>()
    File(filePath).forEachLine { line ->
        if (line.isNotEmpty()) {
            val batteryPack: String = line
            batteryPacks.add(batteryPack)
        }
    }
    return batteryPacks
}

// for this part, i'm thinking dynamic programming might be the best say to solve this
// i'm not too sure but reading the problem makes me think of substring problems using memoisation

// the strategy would be to have a base case at len 12
// there would be 2 recursive calls. one including the current digit and one excluding the current digit
// we would then reduce the size of the string in both of the following recursive calls
fun getBiggestBatteryWithTwelveDigits(batteryPack: String): Int {

}


