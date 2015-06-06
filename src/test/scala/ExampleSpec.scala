import collection.mutable.Stack
import collection.immutable.Queue
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be(2)
    stack.pop() should be(1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a[NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
  "Queue" should "first in, first out" in {
    val queue = Queue(1, 2, 3, 4, 5)
    val (element, _) = queue.dequeue
    element should be(1)
  }
}
