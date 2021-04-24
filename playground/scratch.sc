import scala.language.postfixOps

println("hello")

for (i <- Range.inclusive(1, 10)) { println(
  if (i % 3 == 0 && i % 5 == 0) "FizzBuzz" else if (i % 3 == 0) "Fizz"
  else if (i % 5 == 0) "Buzz"
  else i
) }

val t = (1, true, "hello")

t._2

val a = Array[Int] (1,2,3,4)

a(0)

val a2 = for (i<-a) yield i*i

var f:Int => Int = i => i+1

f(42)

def myLoop(start: Int, end: Int)
          (callback: Int => Unit) = {
  for (i <- Range(start, end)) { callback(i)
  } }

myLoop(10,20) { i => println(s"i=$i") }

def stdDev(a: Array[Double]): Double = {
  val mean = a.sum / a.length
  val squareErrors = a.map(x => x - mean).map(x => x * x)
  math.sqrt(squareErrors.sum / a.length)
}

val x = Array[Double](1, 2, 3,4,5,6,7)
stdDev(x)

val A = Array[Int](1, 2, 3,4,5)
A.find(i => i % 2 == 0 && i > 4)

A.exists(_ < 0) // same as a.exists(x => x < 0) res20: Boolean = false

// sum of all elements
A.foldLeft(0)((x, y) => x + y)
// product
A.foldLeft(1)(_ * _)

