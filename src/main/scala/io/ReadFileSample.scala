package tw.blackwhite.io

object ReadFileSample {
  def readFile(name: String) = {
    val file = scala.io.Source.fromFile("build.sbt")
    val content = file.mkString
    file.close()
    content
  }
  def main(args: Array[String]) = {
    val lines = readFile("build.sbt")
    println(lines)

  }
}
