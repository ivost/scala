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
