
// val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val fruit = "apples" :: "oranges" :: "pears" :: Nil

val nums = List(5, 10, 2, 1)
//////
// insertion sort
def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)

def sort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else insert(xs.head, sort(xs.tail))

////
// with pattern matching
def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs
  else y :: insert2(x, ys)
}

def sort2(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert2(x, sort2(xs1))
}
////
//sort(nums)
//print(sort2(nums))

// pick only elements at odd positions
// 1,2,3,4,5 -> 2,4
def oddPos(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case _ :: x1 :: xs1 => x1 :: oddPos(xs1)
  case _ :: Nil => List()
}

//print(oddPos(nums))
require(oddPos(List()) == List())
require(oddPos(List(1)) == List())
require(oddPos(List(1, 2)) == List(2))
require(oddPos(List(1, 2, 3)) == List(2))
require(oddPos(List(1, 2, 3, 4)) == List(2, 4))
require(oddPos(List(1, 2, 3, 4, 5)) == List(2, 4))






