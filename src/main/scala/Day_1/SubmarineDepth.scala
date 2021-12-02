package Day_1

import Day_1.RawDepthReadings.rawDepthReadings

import scala.collection.mutable.ListBuffer

object SubmarineDepth {

  val depthReadings = rawDepthReadings.split("\n").map(_.toInt).toList

  def convertToSlidingAverageList(lst: List[Int]): List[Int] = {
    var slidingList = new ListBuffer[Int]()
    var i: Int = 2
    while (i != lst.length) {
      slidingList += lst(i) + lst(i - 1) + lst(i - 2)
      i += 1
    }
    slidingList.toList
  }

  def hasIncreased(prev: Int, curr: Int): Boolean = {
    if (curr > prev) true else false
  }

  def countIncreases(readings: List[Int]) = {
    var count = 0
    var prev = readings.head
    for (reading <- readings) {
      if (hasIncreased(prev, reading)) count += 1
      prev = reading
    }
    count
  }

  def main(args: Array[String]): Unit = {

    println(countIncreases(convertToSlidingAverageList(depthReadings)))
  }
}
