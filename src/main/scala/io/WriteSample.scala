package tw.blackwhite.io
import java.nio.file.{ Paths, Files }
import java.nio.charset.StandardCharsets

object WriteFileSample {
  def main(args: Array[String]): Unit = {
    Files.write(Paths.get("file.txt"), "file contents".getBytes(StandardCharsets.UTF_8))
  }
}
