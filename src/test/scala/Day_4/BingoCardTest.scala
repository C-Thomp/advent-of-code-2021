package Day_4

import org.scalatest.funsuite.AnyFunSuite

class BingoCardTest extends AnyFunSuite {

  test("Should initialise bingo card with numbers") {
    val grid: String = "22 13 17 11  0\n 8  2 23  4 24\n21  9 14 16  7\n 6 10  3 18  5\n 1 12 20 15 19"
    val bingoCard = new BingoCard(grid)
    val hasFiveRows = bingoCard.collectionOfRows.length
    val hasFiveColumns = bingoCard.collectionOfColumns.length
    assert(hasFiveRows == 5 &&  hasFiveColumns == 5)
  }
  test("Should constuct columns from given grid") {
    val grid: String = "22 13 17 11 0\n8 2 23 4 24\n21 9 14 16 7\n6 10 3 18 5\n1 12 20 15 19"
    val bingoCard = new BingoCard(grid)

  }
  test("Should have marked a number in a column"){
    val grid: String = "22 13 17 11 0\n8 2 23 4 24\n21 9 14 16 7\n6 10 3 18 5\n1 12 20 15 19"
    val bingoCard = new BingoCard(grid)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(9)
    assert(bingoCard.collectionOfColumns(1).contains("X"))
  }
  test("Should have marked a number in a row"){
    val grid: String = "22 13 17 11 0\n8 2 23 4 24\n21 9 14 16 7\n6 10 3 18 5\n1 12 20 15 19"
    val bingoCard = new BingoCard(grid)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(22)
    assert(bingoCard.collectionOfRows(0).contains("X"))
  }
  test("Should return true for row of marked numbers"){
    val grid: String = " 22  13 17   11  0\n8 2 23 4 24\n21 9 14 16 7\n6 10 3 18 5\n1 12 20 15 19"
    val bingoCard = new BingoCard(grid)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(22)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(13)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(17)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(11)
    bingoCard.collectionOfRows = bingoCard.markNumberInRow(0)
    assert(bingoCard.isWinner(bingoCard.collectionOfRows(0))==true)
  }
  test("Should return true for column of marked numbers"){
    val grid: String = "22 13 17 11 0\n8 2 23 4 24\n21 9 14 16 7\n6 10 3 18 5\n1 12 20 15 19"
    val bingoCard = new BingoCard(grid)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(22)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(8)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(21)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(6)
    bingoCard.collectionOfColumns = bingoCard.markNumberInColumn(1)
    println(bingoCard.collectionOfColumns)
    assert(bingoCard.isWinner(bingoCard.collectionOfColumns(0))==true)
  }

}
