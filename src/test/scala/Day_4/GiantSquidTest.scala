package Day_4

import Day_4.Input._
import org.scalatest.funsuite.AnyFunSuite

class GiantSquidTest extends AnyFunSuite {
  test("Should make a called number by replacing it with X") {
    //Arr: take board/row/column
    //Act: mark a number if it is there
    //assert potion of marked number now contains X
    //markNumber(num/row/board, calledNumber)
  }
  test("Should mark number on board that has been called") {
    //arrange starting board that contains the called number
    //act: mark the called number on board
    //assert new board no longer contains called number
  }
  test("Should check rows in board for winner") {
    //assert column has line of X's
  }
  test("Should check columns in board for winner") {
    //assert row has line of X's
  }
  test("Should sum up all remaining unmarked numbers on a board") {
    //assert sumBoard equals y; finds integers and ignores X's
  }

}
