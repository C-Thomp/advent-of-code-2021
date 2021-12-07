package Day_2

import Day_2.Dive._
import org.scalatest.funsuite.AnyFunSuite


class DiveTest extends AnyFunSuite {

  //PART 1
  test("creates a diver of starting position 0,0") {
    val elf = new diver()
    assert(elf.horiz == 0 && elf.depth == 0)
  }

  test("Horiz increases when going forward") {
    val elf = new diver()
    goForward(elf, 5)
    assert(elf.horiz == 5)
  }
  test("Depth increases when going down") {
    val elf = new diver()
    goDown(elf, 1)
    assert(elf.depth == 1)
  }
  test("Depth decreases when going up") {
    val elf = new diver(depth = 1)
    goUp(elf, 1)
    assert(elf.depth == 0)
  }
  test("does dives work") {
    val elf = new diver()
    dives(elf, "down", 2)
    dives(elf, "forward", 2)
    dives(elf, "up", 1)
    assert(elf.depth == 1 && elf.horiz == 2)
  }
  test("coverts 'forward 2' as tuple") {
    val direction = "forward 2"
    assert(parseInstruction(direction) == Array("forward", 2))
  }
  test("coverts 'down 2' as tuple") {
    val direction = "down 2"
    assert(parseInstruction(direction) == Array("down", 2))
  }
  test("returns coordinates after full list of directions") {
    val elf = new diver()
    val instructions = "forward 2\ndown 4\ndown 1\nup 1".split("\n").toList
    coordinatesAfterFullDive(elf, instructions)
    assert(elf.depth == 4 && elf.horiz == 2)
  }
  test("Multiplies coordinates together") {
    val coordinates = Array(2, 3)
    assert(multiplyHorizontalPotionByDepth(coordinates) == 6)
  }
  //PART 2
  test("Depth changes when going forwards") {
    val elf = new diver(aim = 2)
    goForward(elf, 2)
    assert(elf.depth == 4)
  }


}