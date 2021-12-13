package Day_4

import Day_4.GiantSquid._
import Day_4.Input._
import org.scalatest.funsuite.AnyFunSuite

class GiantSquidTest extends AnyFunSuite {
  test("Should mark number that has been called") {
    var number = "2 22 43"
    assert(markNumber(number, 22) == "2 X 43")
  }
  test("Should sum up all remaining unmarked numbers on a board") {
    //assert sumBoard equals y; finds integers and ignores X's
  }

}
