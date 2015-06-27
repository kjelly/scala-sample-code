package tw.blackwhite.stream.sample

object Streams {
  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
  val primes: Stream[Int] = 2 #:: 3 #:: primes.tail.map(x => {
    def isPrime(number: Int): Boolean = {
      // for getting all known primes
      val primesKnownLength = primes.addString(new StringBuilder, "", ":", "").split(':').length - 2
      (0 to primesKnownLength).map(primes.apply).filter(_ < (math.sqrt(number).toInt + 1)).forall(x => (number % x) != 0)
    }
    def loop(number: Int): Int = {
      if (isPrime(number)) number
      else loop(number + 2)
    }
    loop(x + 2)
  })

  def main(args: Array[String]): Unit = {
    primes.take(230).foreach(println)
  }

  def infinite(n: Int): Stream[Int] = {
    lazy val value: Stream[Int] = n #:: value.map(x => x)
    value
  }

}

