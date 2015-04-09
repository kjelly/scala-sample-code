package tw.blackwhite.dynamic

import scala.concurrent.duration._
import scala.language.dynamics

object DynamicAttribueObject extends Dynamic {
  def applyDynamic(name: String)(args: Any*) = {
    s"name: $name, args: $args"
  }

  def applyDynamicNamed(name: String)(args: (String, Any)*) = {
    s"method '$name' called with arguments ${args.mkString("'", "', '", "'")}"
  }

  def selectDynamic(name: String) = {
    s"name: $name"
  }

  def updateDynamic(name: String)(value: Any) {
    println(s"name: $name, value: $value")
  }

  def method1() = {
    "I am I"
  }
}

object DynamicAttributeSample {
  def main(args: Array[String]): Unit = {
    println(DynamicAttribueObject.hello("world"))
    println(DynamicAttribueObject.hello(a = 1, b = 2))
    println(DynamicAttribueObject.IamAttribue)
    println(DynamicAttribueObject.method1())
  }
}

