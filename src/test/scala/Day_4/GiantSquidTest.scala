package Day_4

import Day_4.GiantSquid._
import Day_4.Input._
import org.scalatest.funsuite.AnyFunSuite

class GiantSquidTest extends AnyFunSuite {
  test("Should make a called number by replacing it with X") {
    //
    //    //Arr: take board/row/column
    //    val result: String = "X 13 17 11  0\n 8  2 23  4 24\n21  9 14 16 7\n 6 10  3 18  5\n 1 12 20 15 19"
    //    //Act: mark a number if it is there
    //    //assert potion of marked number now contains X
    //      assert(markNumberOnBoard(22,testBoards(0))==result)
    //    //markNumber(num/row/board, calledNumber)
  }
  test("Should mark number that has been called") {
    var number = "2 22 43"
    assert(markNumber(number, 22) == "2 X 43")
  }
  test("Should check non winner row in board for winner") {
    val row = "22 X 17 11 X"
    assert(checkRowWin(row) == false)

  }
  test("Should check winning row in board for winner") {
    val row = "X X X X X"
    assert(checkRowWin(row) == true)
  }

  test("Should check columns in board for winner") {
    val winningColumn = ???
    (checkColumnWin(???)==winningColumn)
  }
  test("Should sum up all remaining unmarked numbers on a board") {
    //assert sumBoard equals y; finds integers and ignores X's
  }

}
