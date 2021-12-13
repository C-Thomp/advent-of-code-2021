package Day_4

import Day_4.Input._

object GiantSquid {

  def markNumber(input: String, call: Int) = {
    input.replaceAll(call.toString, "X")
  }

  def checkRowWin(row: String): Boolean = {
    (row == "X X X X X")
  }

  def checkColumnWin(col: String): Unit = {

  }





  def main(args: Array[String]): Unit = {


  }
}
