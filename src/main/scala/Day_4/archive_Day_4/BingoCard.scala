package Day_4.archive_Day_4

import scala.collection.mutable.ArrayBuffer

class BingoCard(grid: String) {

  var collectionOfRows: ArrayBuffer[String] = ArrayBuffer(grid.split("\n"): _*)
  var collectionOfColumns: ArrayBuffer[String] = buildColumns(grid)
  val isWinner = false

  def buildColumns(grid: String) = {
    val rows: Array[String] = grid.split("\n")

    val rawColumns = for (
      colIndex <- 0 to 4;
      row <- rows
    ) yield row.split(" ")(colIndex)

    val columns = for (
      number <- 1 to rawColumns.length
    ) yield if (number % 5 == 0 && number != 0) {
      rawColumns(number - 1) + "\n"
    } else rawColumns(number - 1) + " "

    val arr = columns.mkString.split("\n")
    ArrayBuffer(arr: _*)
  }

  def markNumberInRow(call: Int) = {
    for (row <- collectionOfRows) yield row.replaceAll(call.toString, "X")
  }

  def markNumberInColumn(call: Int) = {
    for (row <- collectionOfColumns) yield row.replaceAll(call.toString, "X")
  }

  def isWinner(chck:String): Boolean ={
    chck.replaceAll(" ","") == "XXXXX"
  }
}
