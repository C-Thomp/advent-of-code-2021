package Day_1

import Day_1.SubmarineDepth._
import org.scalatest.funsuite.AnyFunSuite

class SubmarineDepthTest extends AnyFunSuite {

  test("Should return true is current number is higher than previous") {
    assert(hasIncreased(3, 4) == true)
  }
  test("Should return count of sequential increases in a given list") {
    val givenList = List(1, 2, 3, 4, 5, 1)
    assert(countIncreases(givenList) == 4)
  }
  test("Should convert a list of 3 into a list of one with summed values") {
    val givenList = List(1, 2, 1)
    assert(convertToSlidingAverageList(givenList) == List(4))
  }
  test("Should convert a given list into a sliding door average list") {
    val givenList = List(1, 2, 1, 2, 1)
    assert(convertToSlidingAverageList(givenList) == List(4, 5, 4))
  }
}