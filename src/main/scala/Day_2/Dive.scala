package Day_2

import Day_2.Directions.rawDirections


object Dive {

  val directions = rawDirections.split("\n").toList

  class diver(var horiz: Int = 0, var depth: Int = 0, var aim: Int = 0)

  def goForward(elf: diver, distance: Int) = {
    elf.horiz += distance
    elf.depth += elf.aim * distance
  }

  def goDown(elf: diver, distance: Int) = {
    //elf.depth += distance
    elf.aim += distance
  }

  def goUp(elf: diver, distance: Int) = {
    //elf.depth -= distance
    elf.aim -= distance
  }

  def dives(elf: diver, direction: String, distance: Int) = direction match {
    case "forward" => goForward(elf, distance)
    case "down" => goDown(elf, distance)
    case "up" => goUp(elf, distance)
  }

  def parseInstruction(listOfInstructions: String) = {
    val direction: Array[String] = listOfInstructions.split(" ")
    Array(direction(0), direction(1).toInt)
  }

  def coordinatesAfterFullDive(elf: diver, input: List[String]): Array[Int] = {
    val instructions = input
    for (instruction <- instructions) {
      val parsedInstruction = parseInstruction(instruction)
      val direction = parsedInstruction(0).toString
      val distance = parsedInstruction(1).toString.toInt
      dives(elf, direction, distance)
    }
    Array(elf.horiz, elf.depth)
  }

  def multiplyHorizontalPotionByDepth(coords: Array[Int]): Int = {
    coords(0) * coords(1)

  }

  def main(args: Array[String]): Unit = {
    val scubaElf = new diver()
    val coordinates: Array[Int] = coordinatesAfterFullDive(scubaElf, directions)
    println("The answer is" + multiplyHorizontalPotionByDepth(coordinates))
  }
}