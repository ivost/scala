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

val map = A.groupBy(_ % 2)
// even
map(0)
// odd
map(1)

/*
This implementation receives a Sudoku grid,
represented as a 2-dimensional Array[Array[Int]].
For each i from 0 to 9, we pick out a single row, column,
and 3x3 square.
It then checks that each such row/column/square
has 9 unique numbers by calling .distinct to remove any duplicates,
and then checking if the .length has changed as a result of that removal.

 */
def isValidSudoku(grid: Array[Array[Int]]): Boolean = {
  !Range(0, 9).exists{i =>
    val row = Range(0, 9).map(grid(i)(_))
    val col = Range(0, 9).map(grid(_)(i))
    val square = Range(0, 9).map(j => grid((i % 3) * 3 + j % 3)((i / 3) * 3 + j / 3))
    row.distinct.length != row.length ||
      col.distinct.length != col.length ||
      square.distinct.length != square.length
  }
}

A.to(Vector)
A.to(Set)

/*
Using .view before the map/
slice transformation operations defers the actual
traversal and creation of a new collection until later,
when we call .to to convert it back into a concrete collection type:
 */

A.map(_+1).filter(_%2==0).slice(1,3)

A.view.map(_+1).filter(_%2==0).slice(1,3).to(Array)

val v = Vector(1, 2, 3, 4, 5)
val v1 = v.updated(2, 10)

val v2 = v :+ 1
val v3 = 4 +: v
val v4 = v.tail
v.head

/*
ArrayDeques are general-purpose mutable, linear collections
that provide efficient O(1) indexed lookups,
O(1) indexed updates, and O(1) insertion and removal
at both left and right ends:
 */
val q = collection.mutable.ArrayDeque(1, 2, 3, 4, 5)

q.removeHead()
q.removeLast()
q.append(7)


