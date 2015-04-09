package tw.blackwhite.io
import resource._

object ManagedReadFileSample {
  def readFile(name: String) = {
    val file = scala.io.Source.fromFile("build.sbt")
    val content = file.mkString
    file.close()
    content
  }
  def main(args: Array[String]) = {
    for (input <- managed(scala.io.Source.fromFile("build.sbt"))) {
      val lines = input.mkString
      println(lines)
    }
  }
}
