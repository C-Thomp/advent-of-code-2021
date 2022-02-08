package Day_5

import Day_5.HydrothermalVents.{getAllCoordinates, parseLine}
import org.scalatest.funsuite.AnyFunSuite

class HydrothermalVentsTest extends AnyFunSuite {


  test("parse input returns coordinates") {
    val input = "8,0 -> 0,8"

    assert(parseLine(input) == Seq(Seq(8, 0), Seq(0, 8)))
  }
  test("returns full line of coordinates"){
    val input = Seq(Seq(0,0),Seq(3,0))
    val input2 = Seq(Seq(0,2),Seq(0,0))

    assert(getAllCoordinates(input)== Seq(Seq(0,0),Seq(1,0),Seq(2,0),Seq(3,0)))
    assert(getAllCoordinates(input)== Seq(Seq(0,2),Seq(0,1),Seq(0,0)))

  }
}
