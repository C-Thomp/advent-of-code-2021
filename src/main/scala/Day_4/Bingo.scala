package Day_4

import scala.io.{BufferedSource, Source}

object Bingo {
  val bingoCalls: Array[Int] = Array(38, 54, 68, 93, 72, 12, 33, 8, 98, 88, 21, 91, 53, 61, 26, 36, 18, 80, 73, 47, 3, 5, 55, 92, 67, 52, 25, 40, 56, 95, 9, 62, 30, 31, 85, 65, 14, 2, 78, 75, 15, 39, 87, 27, 58, 42, 60, 32, 41, 83, 51, 77, 10, 66, 70, 4, 37, 6, 89, 23, 16, 49, 48, 63, 94, 97, 86, 64, 74, 82, 7, 0, 11, 71, 44, 43, 50, 69, 45, 81, 20, 28, 46, 79, 90, 34, 35, 96, 99, 59, 1, 76, 22, 24, 17, 57, 13, 19, 84, 29)
  val input: BufferedSource = Source.fromFile("/Users/Carl.Thompson/Documents/Advent-Of-Code-2021/src/main/scala/Day_4/input_day_4")
  val bingoCardStr: Seq[String] = input.getLines().toList.flatMap(_.split(" +"))
  val bingoCardNumbers: Seq[Int] = bingoCardStr.map(n => if (n != "") n.toInt else -1).filter(_ > -1)

  def populateCard(cards: Array[Array[Array[Int]]], bingoNumbers: Seq[Int], numberOfCards: Int): Array[Array[Array[Int]]] = {

    var i = 0
    for (card <- 0 until numberOfCards)
      for (row <- 0 to 4) {
        for (col <- 0 to 4) {
          cards(card)(row)(col) = bingoNumbers(i)
          i += 1
        }
      }
    cards
  }

  def sumUncalledNumbersInCard(card: Array[Array[Int]]): Int = {
    card.flatten.filter(_ > -1).sum
  }

  def markCalledNumber(allBingoCardNumbers: Seq[Int], num: Int) = {
    allBingoCardNumbers.map { e => if (e == num) -1 else e }
  }

  def containsWinningRow(card: Array[Array[Int]]): Boolean = {
    val result = for (row <- 0 to 4) yield card(row).sum < 0
    result.contains(true)
  }

  def containsWinningColumn(card: Array[Array[Int]]): Boolean = {
    containsWinningRow(card.transpose)
  }

  def gamePartOne(bingoCalls: Array[Int], bingoCardNumbers: Seq[Int]): AnyVal = {
    var allCardsNumbers: Seq[Int] = bingoCardNumbers
    val n = bingoCardNumbers.length / 25
    val emptyCard = Array.ofDim[Int](n, 5, 5)

    for (call <- bingoCalls) {
      allCardsNumbers = markCalledNumber(allCardsNumbers, call)

      val bingoCards = populateCard(emptyCard, allCardsNumbers, n)
      for (card <- bingoCards) {
        if (containsWinningRow(card) || containsWinningColumn(card)) {
          println(s"There is a winner at call $call and the answer is " + (sumUncalledNumbersInCard(card) * call))
          return sumUncalledNumbersInCard(card) * call
        }
      }
    }
  }

  def gamePartTwo(bingoCalls: Array[Int], bingoCardNumbers: Seq[Int]): AnyVal = {
    var allCardsNumbers: Seq[Int] = bingoCardNumbers
    val n = bingoCardNumbers.length / 25
    val emptyCard = Array.ofDim[Int](n, 5, 5)

    for (call <- bingoCalls) {
      allCardsNumbers = markCalledNumber(allCardsNumbers, call)

      val bingoCards = populateCard(emptyCard, allCardsNumbers, n)
      for (card <- bingoCards) {
        if (containsWinningRow(card) || containsWinningColumn(card)) {
          println(sumUncalledNumbersInCard(card) * call)
          for (i <- 0 to 4) {
            for (j <- 0 to 4) {
              card(i)(j) = -2
            }
          }
          allCardsNumbers=bingoCards.flatten.flatten.toSeq

        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    //println(gamePartOne(bingoCalls, bingoCardNumbers))
    println(gamePartTwo(bingoCalls, bingoCardNumbers))
  }


}
