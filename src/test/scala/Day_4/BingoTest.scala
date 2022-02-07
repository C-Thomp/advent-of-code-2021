package Day_4

import Day_4.Bingo._
import org.scalatest.funsuite.AnyFunSuite

import scala.io.{BufferedSource, Source}

class BingoTest extends AnyFunSuite {
  val bingoCalls: Array[Int] = Array(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
  val input: BufferedSource = Source.fromFile("/Users/Carl.Thompson/Documents/Advent-Of-Code-2021/src/main/scala/Day_4/testInput")
  val bingoCardStr: Seq[String] = input.getLines().toList.flatMap(_.split(" +"))
  val bingoCardNumbers: Seq[Int] = bingoCardStr.map(n => if (n != "") n.toInt else -1).filter(_ > -1)

  val testCard = populateCard(Array.ofDim[Int](1, 5, 5), bingoCardNumbers, 1)

  test("winning row has been found") {
    for (i <- 0 to 4) testCard(0)(0)(i) = -1
    assert(containsWinningRow(testCard(0)) == true)
  }
  test("winning column has been found") {
    for (i <- 0 to 4) testCard(0)(i)(0) = -1
    assert(containsWinningColumn(testCard(0)) == true)
  }
  test("summing all unmarked elements in array") {
    val card = Array.fill(5, 5)(1)
    card(0)(0) = -20
    assert(sumUncalledNumbersInCard(card) == 24)
  }

  test("test data for game part one") {
    val bingoCalls: Array[Int] = Array(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
    val input: BufferedSource = Source.fromFile("/Users/Carl.Thompson/Documents/Advent-Of-Code-2021/src/main/scala/Day_4/testInput")
    val bingoCardStr: Seq[String] = input.getLines().toList.flatMap(_.split(" +"))
    val bingoCardNumbers: Seq[Int] = bingoCardStr.map(n => if (n != "") n.toInt else -1).filter(_ > -1)
    assert(gamePartOne(bingoCalls, bingoCardNumbers) == 4512)
  }

  test("test data for game part two"){
    val bingoCalls: Array[Int] = Array(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
    val input: BufferedSource = Source.fromFile("/Users/Carl.Thompson/Documents/Advent-Of-Code-2021/src/main/scala/Day_4/testInput")
    val bingoCardStr: Seq[String] = input.getLines().toList.flatMap(_.split(" +"))
    val bingoCardNumbers: Seq[Int] = bingoCardStr.map(n => if (n != "") n.toInt else -1).filter(_ > -1)
    assert(gamePartTwo(bingoCalls, bingoCardNumbers) == 4512)
  }

}
