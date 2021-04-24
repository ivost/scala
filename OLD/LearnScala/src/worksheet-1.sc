import scala.util.Try
import scala.util.matching.Regex


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

Seq("aaa", "bbb").foreach(println)

val a: Array[Char] = Array('1', '2', '3', '4', '5')
a.foreach(println)
val b = swapWithGrouped(a)
b.foreach(println)
println(b.last)

val start = System.currentTimeMillis()
Thread.sleep(300)
//val elapsed = f"${((System.currentTimeMillis() - start).asInstanceOf[Float]/1000)%.1f}"
val elapsed = ((System.currentTimeMillis() - start).asInstanceOf[Float]/1000)

//println(elapsed)
println(f"${elapsed}%.1f sec")

val pattern = "([0-9]+) ([A-Za-z]+)".r
val pattern(count, fruit) = "100 Bananas"

val l1 = "INFO  [SubmitActor]: out: 12/19/16 23:56:31.403 INFO   org.apache.spark.deploy.client.AppClient$ClientEndpoint - Executor added: app-20161219235631-0000/0 on worker-20161219235610-10.0.1.147-57621 (10.0.1.147:57621) with 1 cores"
val l2 = "INFO  [SubmitActor]: out: 12/19/16 23:56:31.500 INFO   org.apache.spark.deploy.client.AppClient$ClientEndpoint - Executor updated: app-20161219235631-0000/0 is now RUNNING"

//val pattern = """.* ([\d]+).*""".r              //> pattern  : scala.util.matching.Regex = .* ([\d]+).*
//val pattern(answerString) = theUltimateAnswer   //> answerString  : String = 42

val pat = """INFO .* Executor added: (.*-[\d]+.[\d]+)/.*""".r
val pat(appid) = l1

l1 match {
  case pat(appid) => println(s"**** FOUND APPID $appid")
  case _ =>
}

//val pat(p1, p2) = l1
//println(s"$p1-$p2")

val imsi = "13410858849878f0"

// todo: trim, swap, remove last if f
// if non-digit - error
val s = imsi.replaceAll("([a-z])", "")
if (s.matches("\\d+")) {
  val a = s.toCharArray
  val sb = StringBuilder.newBuilder
  a.zipWithIndex.foreach { case (c, i) => {
    println(i + " " + c)
  }
    if (i % 2 == 0) {
      if (i + 1 < a.length) {
        sb.append(a(i + 1))
      }
      sb.append(a(i))
    }
  }
}

val sb = new StringBuilder()
sb ++= "foo "
sb ++= "bar "
println(sb.toString)

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





