package Day_5

import scala.io.Source


object HydrothermalVents extends App {

  def parseLine(str: String): Seq[Seq[Int]] = {
    val x = str.split(" -> ").toSeq
    x.map(_.split(",").map(_.toInt).toSeq)
  }

  def getAllCoordinates(coordinates: Seq[Seq[Int]]): Seq[Int] = {
    val flatCoords = coordinates.flatten
    val changeInX: Seq[Int] = Seq(flatCoords(0), flatCoords(2))
    val changeInY: Seq[Int] = Seq(flatCoords(1), flatCoords(3))
    val z: Seq[Int] =  if(changeInX.sum> changeInY.sum) (changeInX(0) to changeInX(1) by 1)


    val result: Seq[Seq[Int]] = ???
  }

  val exampleInput = Source.fromFile("./src/main/scala/Day_5/example_input_5").getLines().toList //Source.fromFile("./example_input_5")
  print(exampleInput(1))

}
