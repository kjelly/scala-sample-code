import scala.util.parsing.combinator._

class Calc extends JavaTokenParsers {
  val memory = Map[String, Double]()

  def expr: Parser[Double] = term ~ rep("+" ~ term | "-" ~ term) ^^ (x => x match {
    case term ~ Nil => term
    case term ~ x => {
      x.foldLeft(term)((l, r) => r match {
        case "+" ~ term => l + term
        case "-" ~ term => l - term
      })
    }
  })

  def term: Parser[Double] = exponent ~ rep("*" ~ exponent | "/" ~ exponent) ^^ (x => x match {
    case factor ~ Nil => factor
    case term ~ x => {
      x.foldLeft(term)((l, r) => r match {
        case "*" ~ term => l * term
        case "/" ~ term => l / term
      })
    }
  })

  def exponent: Parser[Double] = factor ~ opt("^" ~> factor) ^^ (x => x match {
    case factor ~ None => factor
    case base ~ Some(power) => Math.pow(base, power)
  })

  def factor: Parser[Double] = (ident | floatingPointNumber | "(" ~> expr <~ ")") ^^ (x => x match {
    case x: Double => x
    case x: String => {
      try {
        x.toInt
      } catch {
        case e: java.lang.NumberFormatException => memory.get(x).getOrElse(1)
      }
    }
  })
}

object CalcMain extends Calc {
  def main(args: Array[String]) {
    println("input : " + args(0))
    println(parseAll(expr, args(0)))
  }
}

