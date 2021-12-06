package Day_3

import Day_3.Input.rawBinaryInput

import scala.collection.mutable.ArrayBuffer


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
    val size = input.length
    var count = 0
    val isOne = (n: Char) => if (n == '1') count += 1
    for (reading <- input) yield isOne(reading(index))
    val isOneMostCommon = count > (size / 2)
    if (isOneMostCommon) 1 else 0
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

  def filterByMostPopularBit(input: Array[String], index:Int): Array[String] = {
    val bit = getMostCommonbitAtIndex(input, index)
    for (str <- input if str(index).asDigit == bit) yield str

  }

  def main(args: Array[String]): Unit = {
    //println(getPowerConsumption(diagnosticReport))
  }

}
