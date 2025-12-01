package Day01

import java.io.File

fun main() {
    val safeInstance = Safe()
    safeInstance.crackSafe()
    println(safeInstance.getResult())
}

class Safe() {
    private var clicksHeard = 0
    private var currentPos = 50

    fun crackSafe(): Unit {
        val filePath = "src/day_01_input.txt"
        var lineNumber = 0

        File(filePath).forEachLine { line ->
            lineNumber++

            if (line.isNotEmpty()) {
                val direction: Char = line[0]
                val magnitudeString: String = line.substring(1)
                val magnitudeInt: Int = magnitudeString.toInt()

                turnDial(direction, magnitudeInt)
            }
        }
    }

    fun turnDial(direction: Char, magnitude: Int): Unit {
        var currentMag: Int = magnitude
        while (currentMag > 0) {
            if (direction == 'R') {
                currentPos += 1
                currentMag -= 1
                if (currentPos % 100 == 0) clicksHeard += 1
            } else {
                currentPos -= 1
                currentMag -= 1
                if (currentPos % 100 == 0) clicksHeard += 1
                checkDial()
            }
        }
        checkDial()
    }

    fun checkDial(): Unit {
        if (currentPos < 0) currentPos += 100
        if (currentPos >= 100) currentPos -= 100
    }

    fun getResult(): Int {
        return clicksHeard
    }

}

