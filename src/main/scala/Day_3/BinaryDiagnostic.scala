package Day_3

import Day_3.Input.rawBinaryInput

import java.util


object BinaryDiagnostic {

  val diagnosticReport = rawBinaryInput.split("\n").toArray

  def toDecimal(x: String): Int = {
    Integer.parseInt(x, 2)
  }

  def flipBits(x: String) = {
    val bitFlip = (n: Int) => if (n == 0) 1 else 0
    (for (char <- x) yield bitFlip(char.asDigit)).mkString("")
  }

  def getMostCommonbitAtIndex(input: Array[String], index: Int) = {
    var countOnes = 0
    var countZeroes = 0
    val isOne = (n: Char) => if (n == '1') countOnes += 1 else countZeroes += 1
    for (reading <- input) yield isOne(reading(index))
    if (countOnes >= countZeroes) 1 else 0
  }

  def getLeastCommonbitAtIndex(input: Array[String], index: Int) = {
    var countOnes = 0
    var countZeroes = 0
    val isOne = (n: Char) => if (n == '1') countOnes += 1 else countZeroes += 1
    for (reading <- input) yield isOne(reading(index))
    if (countZeroes <= countOnes) 0 else 1
  }

  def getGammaRate(input: Array[String]): Int = {
    val size = input(0).length
    val gammaRate = (for (position <- 0 to size - 1) yield getMostCommonbitAtIndex(input, position)).mkString
    toDecimal(gammaRate)
  }

  def getEpsilonRate(gamma: Int): Int = {
    toDecimal(flipBits(Integer.toBinaryString(gamma)))
  }

  def getPowerConsumption(input: Array[String]): Int = {
    val gam = getGammaRate(input)
    gam * getEpsilonRate(gam)
  }

  def filterByMostPopularBit(input: Array[String], index: Int): Array[String] = {
    val bit = getMostCommonbitAtIndex(input, index)
    for (str <- input if str(index).asDigit == bit) yield str
  }

  def filterByLeastPopularBit(input: Array[String], index: Int): Array[String] = {
    val bit = getLeastCommonbitAtIndex(input, index)
    for (str <- input if str(index).asDigit == bit) yield str
  }

  def getOxygenRating(input: Array[String]): Int = {
    var i = 0
    var output = filterByMostPopularBit(input, 0)
    while (output.length > 1) {
      i += 1
      output = filterByMostPopularBit(output, i)
    }
    toDecimal(output.mkString)
  }

  def getCo2Rating(input: Array[String]): Int = {
    var i = 0
    var output = filterByLeastPopularBit(input, 0)
    while (output.length > 1) {
      i += 1
      //println(output.mkString(" "))
      output = filterByLeastPopularBit(output, i)
    }
    toDecimal(output.mkString)

  }

  def getLifeSupportRating(input:Array[String]): Int = {
    getOxygenRating(input) * getCo2Rating(input)
  }

  def main(args: Array[String]): Unit = {
    println(getLifeSupportRating(diagnosticReport))
  }

}
