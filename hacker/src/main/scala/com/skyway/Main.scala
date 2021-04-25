package com.skyway

object Hacker02 {

  def main(args: Array[String]): Unit = {
    /*
    val a = List(8, 15, 22, 1, 10, 6, 2, 18, 18, 1)
    val a = List()
    println(f1(a))
    f2(3)
    println(f3(a))
    */
    //val a = List(1, 2, 3, 4)
    val a = List(-3,-3,-3)
    println(f(a))
  }

  /*
  https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem
  For a given list with  integers, return a new list
  removing the elements at odd positions.
  1 2 3 4 5 -> 2 4
   */

  def f1(arr: List[Int]): List[Int] =
    arr.zipWithIndex.filter(_._2 % 2 == 1).map(_._1)

  /*
  https://www.hackerrank.com/challenges/fp-array-of-n-elements/problem?h_r=next-challenge&h_v=zen
  Create an array of N integers, where the value of N is passed as an argument
  */
  def f2(num:Int) : List[Int] = List.fill(num)(1)

  // reverse a list
  def f3(a:List[Int]): List[Int] = {
    if (a.isEmpty) return Nil
    f3(a.tail) :+ a.head
  }

  // You are given a list.
  // Return the sum of odd elements from the given list.
  def f4(arr: List[Int]): Int =
    arr.filter(_ % 2 != 0).sum

  // Count the number of elements in an array without
  // using count, size or length operators (or their equivalents).
  def f(a:List[Int]):Int =  a.map(x => 1).sum
}
