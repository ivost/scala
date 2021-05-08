import scala.annotation.tailrec

// factorial
def fact(b: BigInt): BigInt = {
  @tailrec
  def loop(b: BigInt, acc: BigInt): BigInt =
    if (b <= 1) acc
    else loop(b - 1, b * acc)
  loop(b, 1)
}
assert(fact(5) == 5 * fact(4))
fact(20)
// fibonacci
// f(n) = f(n-1) + f(n-2)
// 0  1  2  3  4  5  6  7
// 0, 1, 1, 2, 3, 5, 8, 13
def fib(n: Int): Int = {
  @tailrec
  def f(n: Int, a: Int, b: Int): Int = n match {
    case 0 => a
    case _ => f(n - 1, b, a + b)
  }

  f(n, 0, 1)
}
assert(fib(7) == fib(5) + fib(6))
fib(7)
// find first match, return index or -1 if not found
def findFirst[A](as: Array[A], p: A => Boolean): Int = {
  val l = as.length

  @tailrec
  def loop(n: Int): Int = n match {
    case `l` => -1
    case _ => if (p(as(n))) n else loop(n + 1)
  }

  loop(0)
}
val a = Array(10, 20, 30)
assert(findFirst(a, (x: Int) => x == 10) == 0)
assert(findFirst(a, (x: Int) => x == 30) == 2)
assert(findFirst(a, (x: Int) => x == 25) == -1)

// check is array is sorted
def isSorted[A](as: Array[A], lt: (A, A) => Boolean): Boolean = {
  val len = as.length - 1

  @tailrec
  def loop(n: Int): Boolean = n match {
    case `len` => true
    case _ => if (!lt(as(n), as(n + 1))) false
    else loop(n + 1)
  }

  loop(0)
}
//def lt(a: Int, b: Int) = a < b
val lt = (a: Int, b: Int) => a < b
assert(isSorted(Array[Int](10, 20, 30), lt))
assert(!isSorted(Array[Int](10, 30, 20), lt))