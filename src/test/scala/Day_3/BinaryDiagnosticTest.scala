package Day_3

import Day_3.BinaryDiagnostic._
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ArrayBuffer

class BinaryDiagnosticTest extends AnyFunSuite {
  test("Should convert binary number into decimal") {
    assert(toDecimal("0001") == 1)
    assert(toDecimal("1000") == 8)
  }
  test("returns expected flipped number") {
    assert(flipBits("010") == "101")

  }
  test("find the most common bit at index position") {
    val input = Array("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
    assert(getMostCommonbitAtIndex(input, 0) == 1)
  }
  test("get gamma rate") {
    val input = Array("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
    assert(getGammaRate(input) == 22)
  }
  test("get epsilon rate") {
    assert(getEpsilonRate(22) == 9)
  }
  test("filter input bases on most popular leading bit"){
    val input = Array[String]("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
    val output: Array[String] = Array("11110", "10110", "10111", "10101", "11100", "10000", "11001")
    assert(filterByMostPopularBit(input,0) sameElements output)
  }

}
