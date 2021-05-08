package fpinscala

import fpinscala.List.{drop, dropWhile, sum, tail}

import scala.annotation.tailrec

// `List` data type, parameterized on a type, `A`
sealed trait List[+A]

// A `List` data constructor representing the empty list
case object Nil extends List[Nothing]

/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `Nil` or another `Cons`.
 */
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List { // `List` companion object. Contains functions for creating and working with lists.
  def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
    case Nil => 0 // The sum of the empty list is 0.
    case Cons(x, xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))


  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => xs
  }

  def setHead[A](l: List[A], h: A): List[A] = Cons(h, tail(l))

  @tailrec
  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l else l match {
      case Nil => Nil
      case Cons(x, xs) => drop(xs, n - 1)
    }

  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (!f(x)) l else dropWhile(xs, f)
  }

  def init[A](l: List[A]): List[A] = ???

  def length[A](l: List[A]): Int = ???

  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = ???

  def map[A, B](l: List[A])(f: A => B): List[B] = ???
}

object Main extends App {
  val l = List(1, 2, 3)
  assert(sum(l) == 6)
  assert(tail(l) == List(2, 3))
  assert(tail(List(1)) == Nil)
  assert(tail(List()) == Nil)

  assert(drop(l, 0) == l)
  assert(drop(l, 1) == List(2, 3))
  assert(drop(l, 3) == Nil)
  assert(drop(l, 10) == Nil)
  val d = dropWhile(List(1, 1, 1, 2, 3), (x: Int) => x == 1)
  assert(d == List(2, 3))

}
