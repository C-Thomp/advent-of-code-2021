package Day_10

import scala.io.Source

object SyntaxScoring {

  def isPaired(y: String): Boolean = {

    var x = filterBrackets(y)
    var lastLen: Int = 0
    var len: Int = x.length

    while (lastLen != len) {
      x = x.replace("[]", "").replace("<>","").replace("{}", "").replace("()", "")
      lastLen = len
      len = x.length
    }
    println(x)
    if (x == "") {true} else {false}
  }

  def filterBrackets(str: String): String = {
    var result: String = ""
    val bra = "(){}[]<>"
    for (char <- str if bra.contains(char)){
      result += char
    }
    result
  }



  def main(args: Array[String]): Unit = {
    val exampleInput = Source.fromFile("src/main/scala/Day_10/input_day_10").getLines().toArray
    println(isPaired(exampleInput(0)))

  }
}

