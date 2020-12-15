object BasicFunctions extends App {
  def add(x: Int, y: Int): Int = x + y
  println(add(2, 4))

  def stringifyNumber(x: Int, y: Int):String = s"The numbers ${x} and ${y} are now strings"
  println(stringifyNumber(3,5))

}
