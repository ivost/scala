import scala.util.Try


// swap adjacent

//def swapWithGrouped(a: Array[Int]) = {
//  a.grouped(2).flatMap {
//    case Array(x, y) => Array(y, x)
//    case single => single
//  }.toArray
//}

// _.reverse

def swapWithGrouped(a: Array[Char]) = a.grouped(2).flatMap(_.reverse).toArray
//def swapWithGrouped(a: Array[Int]) = a.grouped(2).map(_.reverse).flatten.toArray

val a: Array[Char] = Array('1', '2', '3', '4', '5')
a.foreach(println)
val b = swapWithGrouped(a)
b.foreach(println)
println(b.last)

val imsi = "13410858849878f0"

// todo: trim, swap, remove last if f
// if non-digit - error

val s = imsi.replaceAll("([a-z])", "")

if (s.matches("\\d+")) {

  val a = s.toCharArray
  val sb =  StringBuilder.newBuilder
  a.zipWithIndex.foreach{ case (c, i) => {
    println( i + " " + c) }
    if (i % 2 == 0) {
      if (i+1 < a.length) {
        sb.append(a(i+1))
      }
      sb.append(a(i))
    }
  }


}


val n = s.toLong

if (Try(s.toLong).isSuccess) {
  println("GOOD")
}

// map
// http://docs.scala-lang.org/overviews/collections/maps.html

val m = Map("name" -> "Ivo", "state" -> "CA")

m.foreach(println)


// https://twitter.github.io/scala_school/pattern-matching-and-functional-composition.html

val one: PartialFunction[Int, String] = { case 1 => "one" }

one(1)

//! one(2)

//val partmap = { case(k, v) => println(k + " -> " + v)}

//partmap((1,2))

// def vs val
// val evaluates when defined.
// def evaluates on every call

def even: (Int => Boolean) = { println("def"); (x => x % 2 == 0) }

val even2: (Int => Boolean) = { println("val"); (x => x % 2 == 0) }

even(2)
even(4)
even(1)

even2(1)
even2(2)
even2(4)
