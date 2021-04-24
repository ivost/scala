package foo
import scala.collection.mutable

/*
https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem
For a given list with  integers, return a new list
removing the elements at odd positions.
1 2 3 4 5 -> 2 4
 */

package object hr_02 {

  def f(a:List[Int]):List[Int] = if (a.length < 2) Nil else {
    // var l = List[Int]()
    val l = mutable.ArrayDeque[Int]()
    var rest = a.tail
    while (rest.length >= 2) {
      l.append(rest.head)
      rest = rest.tail.tail
    }
    l.toList
  }

  def main(args: Array[String]): Unit = {
    val a = List(1, 2, 3, 4, 5, 6)
    println(f(a))
  }

  /*
  override def take(n: Int): List[A] =
  if (isEmpty || n <= 0) Nil else {
      val h = new ::(head, Nil)
      var t = h
      var rest = tail
      var i = 1
      while ({if (rest.isEmpty) return this; i < n}) {
        i += 1
        val nx = new ::(rest.head, Nil)
        t.next = nx
        t = nx
        rest = rest.tail
      }
      releaseFence()
      h
   */

}
