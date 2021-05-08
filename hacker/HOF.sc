import scala.annotation.tailrec

// partial
def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

// curry - convert function with 2 args to func of 1 arg that partially applies it
def curry[A, B, C](f: (A, B) => C): A => B => C = a => b => f(a, b)

// https://www.baeldung.com/scala/currying
val sum: (Int, Int) => Int = (x, y) => x + y
val curriedSum: Int => Int => Int = x => y => x + y
assert(curriedSum(1)(2) == 3)
val sum2 = curriedSum(2)
assert(sum2(40) == 42)
val inc: Int => Int = curriedSum(1)
assert(inc(10) == 11)


@tailrec
def find[A](xs: List[A])(predicate: A => Boolean): Option[A] = {
  xs match {
    case Nil => None
    case head :: tail =>
      if (predicate(head)) Some(head) else find(tail)(predicate)
  }
}

val a = List(1, 2, 3)
val even: Int => Boolean = (x: Int) => x % 2 == 0
assert(find(a)(_ % 2 == 0) == Some(2))

def compose[A, B, C](f: B => C, g: A => B): A => C =
  a => f(g(a))

val my = compose((x: Int) => x + x, (x: Int) => x * x)

assert(my(5) == 50)

