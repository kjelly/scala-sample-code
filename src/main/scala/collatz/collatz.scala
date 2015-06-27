package tw.blackwhite.collatz

object Collatz {
  def main(args: Array[String]): Unit = {
    printf("version 1: ---------------------------\n")
    createCollatz1(13) take 5 foreach (println)
    printf("version 2: ---------------------------\n")
    createCollatz2(13) take 5 foreach (println)

    createCollatz1(0)
  }

  def createCollatz1(n: Int) = {
    require(n > 0, "the first value of collatz should be greater than 0")
    def loop(x: Int): Stream[Int] = {
      var value: Int = 0
      x % 2 match {
        case 1 => {
          value = (x * 3 + 1)
        }
        case 0 => {
          value = x / 2
        }
      }
      value #:: loop(value)
    }
    n #:: loop(n)
  }

  def createCollatz2(n: Int) = {
    require(n > 0, "the first value of collatz should be greater than 0")
    lazy val collatzValue: Stream[Int] = n #:: collatzValue.map(x => {
      var value: Int = 0
      x % 2 match {
        case 1 => {
          value = (x * 3 + 1)
        }
        case 0 => {
          value = x / 2
        }
      }
      value
    })
    collatzValue
  }

}

