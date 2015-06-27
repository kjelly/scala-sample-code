package tw.blackwhite.test.collatz

import tw.blackwhite.collatz.Collatz
import collection.mutable.Stack
import collection.immutable.Queue
import org.scalatest._

class CollatzTest extends FunSuite {
  test("A collatz sequment started from 13 should be 13, 40, 20, 10, 5") {
    val correctValue = List(13, 40, 20, 10, 5)
    assert((Collatz.createCollatz2(13) take 5 toList) == correctValue)
    assert((Collatz.createCollatz1(13) take 5 toList) == correctValue)
  }

  test("A collatz argument should be great than zero") {
    intercept[java.lang.IllegalArgumentException] {
      Collatz.createCollatz1(0)
      Collatz.createCollatz2(0)
    }
  }

  test("the result of createCollatz1 and createCollatz2 should be the same") {
    assert((Collatz.createCollatz1(3) take 5 toList) ==
      (Collatz.createCollatz2(3) take 5 toList))
  }

}